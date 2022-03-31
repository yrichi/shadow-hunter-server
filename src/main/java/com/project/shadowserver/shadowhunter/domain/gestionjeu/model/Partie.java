package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.CartesFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.TypeCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.CarteTerrainFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class Partie {
    List<Joueur> joueurs;
    Boolean isEnd;
    List<TerrainAbstract> terrains;
    int JoueurActuel;
    List<AbstractCarte> carteShadows;
    List<AbstractCarte> carteLumiere;
    List<AbstractCarte> carteVision;


    public void initPartie(int nbJoueur) {
        setJoueurs(initJoueurs(nbJoueur));
        setCarteLumiere(CartesFactory.getCartes(TypeCarteEnum.LUMIERE));
        setCarteShadows(CartesFactory.getCartes(TypeCarteEnum.TENEBRE));
        setCarteVision(CartesFactory.getCartes(TypeCarteEnum.VISION));
        setTerrains(initTerrain());
    }

    private List<TerrainAbstract> initTerrain() {
        return Arrays.stream(TerrainEnum.values()).map(CarteTerrainFactory::getTerrain).collect(Collectors.toList());
    }



    private List<Joueur> initJoueurs(int nbJoueur) {
        List<Joueur> joueurs = new ArrayList<>();
        List<PersonnageEnum> roles = Arrays.asList(PersonnageEnum.values());
        // TODO faire un random pour la la liste de roles
        for (int i = 0; i < nbJoueur; i++) {
            joueurs.add(initJoueurByPersonnage(roles.get(i)));
        }
        return joueurs;
    }

    private Joueur initJoueurByPersonnage(PersonnageEnum personnageEnum) {
        return Joueur.builder().cartePersonnage(CartePersonnageFactory.initPersonnage(personnageEnum)).build();
    }


}
