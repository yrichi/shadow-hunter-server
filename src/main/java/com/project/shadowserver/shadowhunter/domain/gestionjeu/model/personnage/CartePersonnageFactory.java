package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages.Vampire;

public class CartePersonnageFactory {


    public static CartePersonnageAbstract initPersonnage(PersonnageEnum personnageEnum) {
        switch (personnageEnum) {
            case VAMPIRE:
                return new Vampire();
        }
        return null;
    }
}
