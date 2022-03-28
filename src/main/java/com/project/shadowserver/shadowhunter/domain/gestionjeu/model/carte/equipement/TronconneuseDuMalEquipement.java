package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class TronconneuseDuMalEquipement extends TypeEquipementAbstract {

    public TronconneuseDuMalEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_ATTAQUE);
    }

    @Override
    public int getDammagesEmitted(int nbDammage) {
        return super.increaseDamage(nbDammage);
    }

    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
