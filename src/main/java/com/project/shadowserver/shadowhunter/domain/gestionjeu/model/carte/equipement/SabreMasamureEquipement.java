package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class SabreMasamureEquipement extends TypeEquipementAbstract {

    public SabreMasamureEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_SPECIAL);
        this.setTypeDesEnum(TypeDesEnum.DES_4);
    }



    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
