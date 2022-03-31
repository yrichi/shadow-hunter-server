package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.effectterrain.ForetHanteEffect;

public class ForetHantee extends TerrainAbstract {


    public ForetHantee() {
        this.getIndexPosition().add(9);
        this.setTerrainEnum(TerrainEnum.FORET_HANTE);
        this.setEffetTerrain(new ForetHanteEffect());
    }
}
