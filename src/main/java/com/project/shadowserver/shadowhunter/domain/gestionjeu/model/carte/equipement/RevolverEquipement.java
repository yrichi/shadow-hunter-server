package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class RevolverEquipement extends TypeEquipementAbstract {

    public RevolverEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_ATTAQUE);
        this.setAreaAffectedEnum(AreaAffectedEnum.OTHER_SECTOR);
    }


    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
