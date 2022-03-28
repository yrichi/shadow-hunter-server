package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

import java.util.List;

public class TogeSainteEquipement extends TypeEquipementAbstract {

    public TogeSainteEquipement() {
        this.getTypeEquipementEffectEnum().addAll(List.of(TypeEquipementEffectEnum.EFFET_ATTAQUE, TypeEquipementEffectEnum.EFFET_DEFENSE));
    }

    @Override
    public String getNotification() {
        return "attaque reduit de 1 et blessure reduit de 1";
    }

    @Override
    public int getDammagesEmitted(int nbDammage) {
        return super.decreaseDamage(nbDammage);
    }

    @Override
    public int getDammagesReceived(int nbDammage) {
        return nbDammage > 0 ? nbDammage - 1 : 0;
    }
}
