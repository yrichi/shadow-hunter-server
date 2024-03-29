package com.project.shadowserver.shadowhunter.domain.util;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;


public class DiceRollUtil {


    public static int diceRoll(TypeDesEnum typeDesEnum) {
        switch (typeDesEnum) {
            case DES_6:
                return (int) (6.0 * Math.random()) + 1;
                // TODO on veut la difference des deux des
            case DOUBLE_DES_6:
                return Math.abs(((int) (6.0 * Math.random()) + 1)-(((int) (6.0 * Math.random()) + 1)));
            case DES_4:
                return (int) (4.0 * Math.random()) + 1;
            default:
                return 0;
        }
    }
}


