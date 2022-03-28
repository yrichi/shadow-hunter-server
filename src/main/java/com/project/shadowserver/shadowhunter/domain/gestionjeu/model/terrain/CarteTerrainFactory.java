package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.terrains.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CarteTerrainFactory {


    public static TerrainAbstract getTerrain(TerrainEnum terrainEnum){
        // comme pour les equipement refacto a prevoir ici pour faire sauter le switch et deplacer les conditions coté implementation des terrains abstracts
        switch (terrainEnum){
            case DEPART:
                return new Depart();
            case SANCTUAIRE_ANCIEN:
                return new SanctuaireAncien();
            case ANTRE_ERMITE:
                return new AntreErmite();
            case CIMETIERE:
                return new Cimetiere();
            case MONASTERE:
                return new Cimetiere();
            case FORET_HANTE:
                return new ForetHantee();
            default:
                log.error("pas de terrain trouvé");
                return null;

        }
    }
}
