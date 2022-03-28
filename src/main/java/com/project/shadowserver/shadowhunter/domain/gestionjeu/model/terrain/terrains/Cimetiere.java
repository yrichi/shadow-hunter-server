package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;

import java.util.List;

public class Cimetiere extends TerrainAbstract {


    public Cimetiere() {
        this.getIndexPosition().addAll(List.of(8));
        this.setTerrainEnum(TerrainEnum.CIMETIERE);
    }
}
