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
       partie.initPartie(nbJoueur);
        return partie;
    }

}
