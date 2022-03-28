package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class CrucifixEnArgentEquipement extends TypeEquipementAbstract {

    public CrucifixEnArgentEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_SPECIAL);
    }

    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
