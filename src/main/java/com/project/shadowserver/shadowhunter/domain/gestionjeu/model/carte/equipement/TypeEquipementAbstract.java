package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public abstract class TypeEquipementAbstract {
    List<TypeEquipementEffectEnum> typeEquipementEffectEnum = new ArrayList<>();
    TypeDesEnum typeDesEnum = TypeDesEnum.DES_6;
    NomCarteEnum nomCarte;
    AreaAffectedEnum areaAffectedEnum = AreaAffectedEnum.SAME_SECTOR;

    public abstract String getNotification();

    public int getDammagesEmitted(int nbDammage) {
        return nbDammage;
    }

    public int getDammagesReceived(int nbDammage) {
        return nbDammage;
    }

    protected int increaseDamage(int nbDammage) {
        return nbDammage > 0 ? (nbDammage + 1) : 0;
    }


    protected int decreaseDamage(int nbDammage) {
        return nbDammage > 0 ? (nbDammage - 1) : 0;
    }
}
