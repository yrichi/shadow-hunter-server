package com.project.shadowserver.shadowhunter.application.gestionjeu.presentation;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.ActionAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.ActionFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.TypeAction;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public class ActionPresentation {

    TerrainEnum terrainCible;
    PersonnageEnum emeteur;
    PersonnageEnum cible;
    TypeAction typeAction;
    OptionEnum optionEnum;


    public ActionAbstract toDomain() {
        return ActionFactory.buildAction(terrainCible,emeteur,cible,typeAction,optionEnum);
    }
}
