package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.LoupGarouPouvoir;

public class LoupGarou extends CartePersonnageAbstract {

    public LoupGarou() {
        this.setPersonnageEnum(PersonnageEnum.LOUP_GAROU);
        this.setNombreDePointDeVie(14);
        this.setRole(RoleEnum.SHADOW);
        this.setPouvoir(new LoupGarouPouvoir());
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
