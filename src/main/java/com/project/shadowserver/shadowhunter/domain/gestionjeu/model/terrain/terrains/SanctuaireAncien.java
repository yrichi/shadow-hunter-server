package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.effectterrain.SantuaireAncienEffect;

public class SanctuaireAncien extends TerrainAbstract {


    public SanctuaireAncien() {
        this.getIndexPosition().add(10);
        this.setTerrainEnum(TerrainEnum.SANCTUAIRE_ANCIEN);
        this.setEffetTerrain(new SantuaireAncienEffect());
    }
}
