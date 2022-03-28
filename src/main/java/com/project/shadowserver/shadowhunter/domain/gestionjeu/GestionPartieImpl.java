package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.TypeCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.CarteTerrainFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GestionPartieImpl implements GestionPartie {
    @Override
    public Partie creerPartie(int nbJoueur) {

        Partie partie = initPartie(nbJoueur);

        return partie;
    }

    @Override
    public Option getOptionJoueurs(String idJoueur) {
        return null;
    }

    @Override
    public Partie getUpdatedPartie(PersonnageEnum personnageEnum) {
        return null;
    }

    private Partie initPartie(int nbJoueur) {
        Partie partie = new Partie();
        partie.setJoueurs(initJoueurs(nbJoueur));
        partie.setCarteLumiere(initCarte(TypeCarteEnum.LUMIERE));
        partie.setCarteShadows(initCarte(TypeCarteEnum.TENEBRE));
        partie.setCarteVision(initCarte(TypeCarteEnum.VISION));
        partie.setTerrains(initTerrain());
        return partie;
    }

    private List<TerrainAbstract> initTerrain() {
        return Arrays.stream(TerrainEnum.values()).map(CarteTerrainFactory::getTerrain).collect(Collectors.toList());
    }

    private List<AbstractCarte> initCarte(TypeCarteEnum typeCarte) {
        switch (typeCarte){
            case TENEBRE:
                return null;
        }
        return null;
    }

    private List<Joueur> initJoueurs(int nbJoueur) {
        List<Joueur> joueurs = new ArrayList<>();
        List<PersonnageEnum> roles = Arrays.asList(PersonnageEnum.values());
        // TODO random la liste de roles
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(initJoueurByPersonnage(roles.get(i)));
        }
        return joueurs;
    }

    private Joueur initJoueurByPersonnage(PersonnageEnum personnageEnum) {
        return Joueur.builder().cartePersonnage(CartePersonnageFactory.initPersonnage(personnageEnum)).build();
    }

}
