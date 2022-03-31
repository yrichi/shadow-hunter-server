package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.DanielPouvoir;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.VampirePouvoir;

public class Daniel extends CartePersonnageAbstract {

    public Daniel() {
        this.setPersonnageEnum(PersonnageEnum.DANIEL);
        this.setNombreDePointDeVie(13);
        this.setRole(RoleEnum.NEUTRE);
        this.setPouvoir(new DanielPouvoir());
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
