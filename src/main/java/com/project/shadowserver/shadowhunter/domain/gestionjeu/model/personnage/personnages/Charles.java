package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.pouvoir.CharlesPouvoir;

public class Charles extends CartePersonnageAbstract {

    public Charles() {
        this.setPersonnageEnum(PersonnageEnum.CHARLES);
        this.setNombreDePointDeVie(11);
        this.setRole(RoleEnum.NEUTRE);
        this.setPouvoir(new CharlesPouvoir());
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
