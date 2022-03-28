package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;

import java.util.List;

public class AntreErmite extends TerrainAbstract {


    public AntreErmite() {
        this.getIndexPosition().addAll(List.of(2,3));
        this.setTerrainEnum(TerrainEnum.ANTRE_ERMITE);
    }
}
