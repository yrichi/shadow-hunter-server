package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.ActionAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import java.util.List;

public interface GestionPartie {

    Partie creerPartie(String idJoueur,int nbJoueur);

    List<Option> getOptionJoueurs(String idPartie,String idJoueur);

    void  applyAction(String idPartie, String idJoueur, ActionAbstract actionAbstract);


    Partie getUpdatedPartie(String idPartie, String joueurId);
}
