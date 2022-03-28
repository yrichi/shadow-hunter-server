package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;

public class Depart extends TerrainAbstract {


    public Depart() {
        this.getIndexPosition().add(0);
        this.setTerrainEnum(TerrainEnum.DEPART);
    }
}
