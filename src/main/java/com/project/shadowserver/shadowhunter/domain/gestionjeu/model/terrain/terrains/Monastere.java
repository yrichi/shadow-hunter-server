package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.effectterrain.MonastereEffect;

import java.util.List;

public class Monastere extends TerrainAbstract {


    public Monastere() {
        this.getIndexPosition().addAll(List.of(6));
        this.setTerrainEnum(TerrainEnum.MONASTERE);
        this.setEffetTerrain(new MonastereEffect());
    }
}
