package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement;

public class MaitrailleuseFunesteEquipement extends TypeEquipementAbstract {

    public MaitrailleuseFunesteEquipement() {
        this.getTypeEquipementEffectEnum().add(TypeEquipementEffectEnum.EFFET_ATTAQUE);
        this.areaAffectedEnum =AreaAffectedEnum.ALL_IN_SECTOR;
    }

    @Override
    public String getNotification() {
        return "Les attaques ne vous infligent aucune blessure jusqu'à votre prochain tour";
    }
}
