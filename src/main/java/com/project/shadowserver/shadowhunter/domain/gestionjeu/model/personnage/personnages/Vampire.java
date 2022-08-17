package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;

public class Vampire extends CartePersonnageAbstract {

    public Vampire() {
        this.setPersonnageEnum(PersonnageEnum.VAMPIRE);
        this.setNombreDePointDeVie(13);
        this.setRole(RoleEnum.SHADOW);
    }

    @Override
    public void usePower(Joueur joueurEmeteur, Joueur joueurCible, Partie partie, int degat) {
        // TODO
    }

    ;

    @Override
    public boolean conditionDeVictoire(Partie partie) {
        return false;
    }

    @Override
    public boolean canUsePower() {
        return false;
    }
}
