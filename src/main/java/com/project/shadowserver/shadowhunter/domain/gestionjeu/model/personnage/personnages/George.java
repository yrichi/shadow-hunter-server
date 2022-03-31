package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.FranklinPouvoir;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.GeorgesPouvoir;

public class George extends CartePersonnageAbstract {

    public George() {
        this.setPersonnageEnum(PersonnageEnum.FRANKLIN);
        this.setNombreDePointDeVie(14);
        this.setRole(RoleEnum.HUNTER);
        this.setPouvoir(new GeorgesPouvoir());
    }

    @Override
    public String usePower(PersonnageEnum personnageEmeteur, Partie partie, PersonnageEnum personnageRecepteur) {
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
