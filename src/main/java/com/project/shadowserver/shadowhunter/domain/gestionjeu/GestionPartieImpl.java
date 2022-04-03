package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.ActionAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.provider.PartieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GestionPartieImpl implements GestionPartie {

    private final PartieProvider partieProvider;


    @Override
    public Partie creerPartie(String idJoueur, int nbJoueur) {
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
    public Partie getUpdatedPartie(String idPartie, String joueurId) {
        return null;
    }


    private Partie initPartie(int nbJoueur) {
        Partie partie = new Partie();
        partie.initPartie(nbJoueur);
        return partie;
    }

}
