package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.ActionAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GestionPartieImpl implements GestionPartie {



    @Override
    public Partie creerPartie(int nbJoueur) {
        Partie partie = initPartie(nbJoueur);
        return partie;
    }

    @Override
    public List<Option> getOptionJoueurs(String idPartie, String idJoueur) {
        return null;
    }

    @Override
    public void applyAction(String idPartie, String idJoueur, ActionAbstract actionAbstract) {

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
