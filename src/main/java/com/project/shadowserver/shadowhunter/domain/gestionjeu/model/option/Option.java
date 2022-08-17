package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;


import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class Option {
    private OptionEnum optionEnum;
    private Boolean isRequired = false;
    private List<TerrainEnum> terrainsCible ;
    private List<PersonnageEnum> personnageCible;
}
