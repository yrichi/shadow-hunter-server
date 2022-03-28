package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.vampire;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;

public class VampireCartePersonnage extends CartePersonnageAbstract {

    public VampireCartePersonnage() {
        this.setPersonnageEnum(PersonnageEnum.VAMPIRE);
        this.setNombreDePointDeVie(13);
        this.setRole(RoleEnum.SHADOW);
        this.setPouvoir(new VampirePouvoir());
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
