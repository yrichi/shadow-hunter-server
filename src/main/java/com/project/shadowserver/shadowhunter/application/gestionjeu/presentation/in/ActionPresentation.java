package com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.in;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.Action;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public class ActionPresentation {

    private TerrainEnum terrainCible;
    private String idEmeteur;
    private String idCible;
    private NomCarteEnum carteUtilise;
    private OptionEnum optionEnum;


    public Action toDomain() {
        return new Action(terrainCible,idEmeteur,idCible,optionEnum,carteUtilise);
    }
}
