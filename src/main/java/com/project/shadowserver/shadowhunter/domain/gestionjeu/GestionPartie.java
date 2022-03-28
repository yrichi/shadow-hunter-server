package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;

public interface GestionPartie {

    Partie creerPartie(int nbJoueur);

    Option getOptionJoueurs(String idJoueur);

    Partie getUpdatedPartie(PersonnageEnum personnageEnum);



}
