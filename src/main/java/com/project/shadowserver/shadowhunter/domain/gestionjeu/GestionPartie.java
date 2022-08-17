package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.Action;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import java.util.List;

public interface GestionPartie {

    Partie creerPartie(String idJoueur);

    Partie commencerPartie(String idPartie,String idJoueur);


    Partie applyAction(String idPartie, String idJoueur, Action action);


    Partie getPartie(String idPartie, String joueurId);
}
