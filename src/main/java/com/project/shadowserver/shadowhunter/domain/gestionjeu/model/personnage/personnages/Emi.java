package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.EmiPouvoir;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.VampirePouvoir;

public class Emi extends CartePersonnageAbstract {

    public Emi() {
        this.setPersonnageEnum(PersonnageEnum.EMI);
        this.setNombreDePointDeVie(10);
        this.setRole(RoleEnum.HUNTER);
        this.setPouvoir(new EmiPouvoir());
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
