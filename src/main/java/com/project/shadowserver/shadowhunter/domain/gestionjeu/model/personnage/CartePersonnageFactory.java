package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages.*;
import lombok.extern.log4j.Log4j2;


@Log4j2
public class CartePersonnageFactory {


    public static CartePersonnageAbstract initPersonnage(PersonnageEnum personnageEnum) {
        switch (personnageEnum) {
            case VAMPIRE:
                return new Vampire();
            case BOB:
                return new Bob();
            case ALLIE:
                return new Allie();
            case EMI:
                return new Emi();
            case CHARLES:
                return new Charles();
            case DANIEL:
                return new Daniel();
            case FRANKLIN:
                return new Franklin();
            case GEORGES:
                return new George();
            case LOUP_GAROU:
                return new LoupGarou();
            case METAMORPHE:
                return new Metamorphe();
            default:
                log.error("Aucune carte personnages correspondante");
                return null;
        }
    }
}
