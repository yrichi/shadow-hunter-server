package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class LanceEquipement extends TypeEquipementAbstract {

    public LanceEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_ATTAQUE);
    }

    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
