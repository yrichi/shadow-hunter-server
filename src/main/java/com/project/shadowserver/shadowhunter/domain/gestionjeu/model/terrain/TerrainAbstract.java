package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.effectterrain.EffetTerrainAbstract;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
abstract public class TerrainAbstract {
    TerrainEnum terrainEnum;
    EffetTerrainAbstract effetTerrain;
    List<Integer> indexPosition = new ArrayList<>();
}
