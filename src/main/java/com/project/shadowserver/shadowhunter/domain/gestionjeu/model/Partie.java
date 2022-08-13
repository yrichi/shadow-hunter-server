package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.Action;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.CarteTerrainFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.util.DiceRollUtil;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

@Data
@Log4j2
public class Partie {
    public static final int NB_JOUEUR_MAX = 8;
    private String idPartie;

    private String waitingIdPlayer;
    private EtatPartie etatPartie;
    private String idJoueurCreateur;

    private List<Joueur> joueurs = new ArrayList<>();
    private Boolean isEnd;
    private List<TerrainAbstract> terrains = new ArrayList<>();
    private String idJoueurActuel;
    private List<AbstractCarte> carteShadows = new ArrayList<>();
    private List<AbstractCarte> carteLumiere = new ArrayList<>();
    private List<AbstractCarte> carteVision = new ArrayList<>();


    public void initPartie(String idJoueur) {
        idJoueurCreateur = idJoueur;
        etatPartie = EtatPartie.EN_PREPARATION;
        // TODO random a prevoir
        setCarteLumiere(CartesFactory.getCartes(TypeCarteEnum.LUMIERE));
        setCarteShadows(CartesFactory.getCartes(TypeCarteEnum.TENEBRE));
        setCarteVision(CartesFactory.getCartes(TypeCarteEnum.VISION));
        setTerrains(initTerrain());
        rejoindrePartie(idJoueur);
    }

    public void commencerPartie() {
        var nbJoueur = (int) joueurs.stream().filter(joueur -> StringUtils.isNotBlank(joueur.getIdUtilisateur())).count();
        if (nbJoueur <= NB_JOUEUR_MAX && nbJoueur >= 4) {
            etatPartie = EtatPartie.EN_COURS;
            List<PersonnageEnum> roles = Arrays.asList(PersonnageEnum.values());
            // TODO faire un random pour la la liste de roles
            for (int i = 0; i < nbJoueur; i++) {
                var joueur = joueurs.get(i);
                joueur.setCartePersonnage(CartePersonnageFactory.initPersonnage(roles.get(i)));
            }
        }
        // TODO exception car pas assez de joueur ( ou trop)
    }

    public void finPartie() {
        etatPartie = EtatPartie.TERMINE;
    }

    private List<TerrainAbstract> initTerrain() {
        return Arrays.stream(TerrainEnum.values()).map(CarteTerrainFactory::getTerrain).collect(Collectors.toList());
    }


    public void rejoindrePartie(String idJoueur) {
        if (etatPartie == EtatPartie.EN_PREPARATION && joueurs.size() < NB_JOUEUR_MAX) {
            joueurs.add(Joueur.builder().idUtilisateur(idJoueur).build());
        }
        // TODO exception a mettre en place si il ne reste plus de place dans la partie ou si la partie a deja commencé
    }

    public Partie getPartie(String idJoueur) {
        return this; // TODO il faudrait une PartiePresentation, dependant de l'idJoueur et qui ne va afficher que les informations lié au joueurs
    }

    public List<OptionEnum> getOptions(String idJoueur) {
        return getJoueur(idJoueur).getOptions().stream().collect(Collectors.toList());
    }


    public Joueur getJoueur(String idJoueur) {
        return getJoueurs().stream().filter(joueur -> Objects.equals(joueur.getIdUtilisateur(), idJoueur)).findAny().orElse(null);
    }

    public void setJoueurEnCours(String idJoueur) {
        idJoueurActuel = idJoueur;
        var joueurActuel = getJoueur(idJoueur);
        joueurActuel.initOptionsNewTurn();
        // TODO si il a deja la carte ange gardien alors elle doit etre defaussé
    }

    public void nextJoueurEnCours() {
        var indexJoueurActuel = findIndexJoueurActuel();

        var joueurActuel = joueurs.get(indexJoueurActuel);
        joueurActuel.initOptionsNewTurn();
        if (joueurActuel.isEquipmentExist(NomCarteEnum.ANGE_GARDIEN)) {
            joueurActuel.removeEquipement(NomCarteEnum.ANGE_GARDIEN);
        }
    }

    private int findIndexJoueurActuel() {
        for (int i = 0; i < joueurs.size(); i++) {
            if (Objects.equals(joueurs.get(i).getIdUtilisateur(), idJoueurActuel)) {
                return i < i ? i : 0;
            }
        }
        log.debug("ne trouve pas l'index du joueur actuel");
        return 0;
    }

    ;

    public void applyAction(Action action) {
        action.apply(this);
        updateOptionsJoueur();
    }

    private void updateOptionsJoueur() {

    }

    public void deplacement(String idJoueurEmeteur) {
        int lancerDeDes = DiceRollUtil.diceRoll(TypeDesEnum.DOUBLE_DES_6);
        Joueur personnage = getJoueur(idJoueurEmeteur);
        if (lancerDeDes == 7) {
            personnage.getOptions().add(OptionEnum.DEPLACER_VERS_TERRAIN);
            personnage.getNotifications().add(
                    NotificationFactory.buildNotification(
                            TypeNotificationEnum.INFORMATIF,
                            idJoueurEmeteur,
                            "vous avez fait un 7 ! selectionner un terrain cible de votre choix")
            );
        } else {
            var terrain = getTerrains().stream().filter(terrainAbstract -> terrainAbstract.getIndexPosition().contains(lancerDeDes)).findAny().orElse(null);
            deplacement(idJoueurEmeteur, terrain.getTerrainEnum());
        }
    }

    public void deplacement(String idJoueurEmeteur, TerrainEnum terrain) {
        Joueur personnage = getJoueur(idJoueurEmeteur);
        if (terrain == null) {
            log.debug("terrain non trouvé pour le deplacement : erreur non prevu "); // TODO a delete
        }
        personnage.setPositionTerrain(terrain);
        NotificationFactory.buildNotification(
                TypeNotificationEnum.INFORMATIF,
                idJoueurEmeteur,
                String.format("vous etes dirigé vers le terrain %s", personnage.getPositionTerrain().name())
        );

    }

    public void attaquer(String idJoueurEmeteur, String idJoueurCible, TerrainEnum terrainCible) {
        Joueur joueurEmeteur = getJoueur(idJoueurEmeteur);
        if (joueurEmeteur.isEquipmentExist(NomCarteEnum.MITRAILLETTE_FUNESTE)) {
            var joueursCible = findJoueursAdjacent(terrainCible);
            joueursCible.forEach(joueur -> joueurEmeteur.attaque(joueur));
        }
        Joueur joueurCible = getJoueur(idJoueurCible);
        joueurEmeteur.attaque(joueurCible);


        /* TODO a implementer
    - lancée de des
    - increase degat selon les equipements du joueur emeteur
    - decrease degat selon les equipements du joueurs cible
    - pouvoir de l'emeteur utilisable ( vampire,etc)
    - pouvoir de la cible utilisable ( loup garou )

         */
    }

    private List<Joueur> findJoueursAdjacent(TerrainEnum terrainCible) {
        for (int i = 0; i < terrains.size(); i++) {
            if (terrains.get(i).getTerrainEnum().equals(terrainCible)) {
                int indexTerrainAdjacent = i % 2 == 0 ? i + 1 : i-1;
                var terrainAdjecent = terrains.get(indexTerrainAdjacent);
                return joueurs.stream().filter(joueur -> List.of(terrainCible,terrainAdjecent).contains(joueur.getPositionTerrain())).collect(Collectors.toList());
            }
        }
        return Collections.emptyList();
    }

    public void seReveler(String idJoueurEmeteur) {
        Joueur personnage = getJoueur(idJoueurEmeteur);
        personnage.getCartePersonnage().setHidden(false);
    }

    public void utiliserPouvoir(String idJoueurEmeteur, String idJoueurCible) {
        Joueur joueurEmeteur = getJoueur(idJoueurEmeteur);
        Joueur joueurCible = getJoueur(idJoueurCible);
        joueurEmeteur.getCartePersonnage().getPouvoir().effetPouvoir(joueurEmeteur, joueurCible, this);
    }

    public void utiliserCarte(String idJoueurEmeteur, String idJoueurCible, NomCarteEnum carteUtilise) {
        var joueurEmeteur = getJoueur(idJoueurEmeteur);
        var joueurCible = getJoueur(idJoueurCible);
        var carte = CarteFactory.getCarte(carteUtilise);
        carte.effetCarte(joueurEmeteur, joueurCible, this);
    }

    public void subirBlessureForetHante(String idJoueurEmeteur, String idJoueurCible) {
        var joueurCible = getJoueur(idJoueurCible);
        if (joueurCible.isNotVunerableForetHante()) {
            joueurCible.getNotifications().add(NotificationFactory.buildNotification(TypeNotificationEnum.ATTAQUE, idJoueurCible, String.format("le joueur %s n'est pas sensible à l'attaque", joueurCible.getCartePersonnage().getPersonnageEnum())));
        } else {
            joueurCible.blesse(2);
        }
    }

    public void soignerBlessureForetHante(String idJoueurEmeteur, String idJoueurCible) {
        var joueurCible = getJoueur(idJoueurCible);
        joueurCible.soigner(1);
    }

    public void donnerEquipement(String idJoueurEmeteur, String idJoueurCible, NomCarteEnum carteCible) {
        var joueurEmeteur = getJoueur(idJoueurEmeteur);
        var joueurCible = getJoueur(idJoueurCible);
        joueurEmeteur.transfertCarteEquipement(joueurCible, carteCible);
    }

    public void volerEquipement(String idJoueurEmeteur, String idJoueurCible, NomCarteEnum carteCible) {
        var joueurEmeteur = getJoueur(idJoueurEmeteur);
        var joueurCible = getJoueur(idJoueurCible);
        joueurCible.transfertCarteEquipement(joueurEmeteur, carteCible);
    }

    public void choisirCarte(String idJoueurEmeteur, TypeCarteEnum typeCarte) {
        var joueurEmeteur = getJoueur(idJoueurEmeteur);
        if (TypeCarteEnum.VISION.equals(typeCarte)) {
            var carte = tirerCarte(typeCarte);
            joueurEmeteur.ajouterEquipement(carte);
        }
    }

    private AbstractCarte tirerCarte(TypeCarteEnum typeCarte) {
        switch (typeCarte) {
            case VISION:
                return carteVision.stream().filter(abstractCarte -> !BooleanUtils.toBoolean(abstractCarte.getIsDefausse())).findAny().orElse(null);
            case LUMIERE:
                return carteLumiere.stream().filter(abstractCarte -> !BooleanUtils.toBoolean(abstractCarte.getIsDefausse())).findAny().orElse(null);
            case TENEBRE:
                return getCarteShadows().stream().filter(abstractCarte -> !BooleanUtils.toBoolean(abstractCarte.getIsDefausse())).findAny().orElse(null);
            default:
                log.debug("impossible de tirer une carte ", typeCarte);
                return null;

        }
    }

    ;
}
