package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.FranklinPouvoir;

public class Franklin extends CartePersonnageAbstract {

    public Franklin() {
        this.setPersonnageEnum(PersonnageEnum.FRANKLIN);
        this.setNombreDePointDeVie(12);
        this.setRole(RoleEnum.HUNTER);
        this.setPouvoir(new FranklinPouvoir());
    }

    @Override
    public String usePower(Joueur joueurEmeteur, Joueur joueurCible, Partie partie) {
        // TODO
        return "";
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
