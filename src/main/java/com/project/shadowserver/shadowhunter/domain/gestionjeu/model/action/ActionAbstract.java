package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public abstract class ActionAbstract {
    TerrainEnum terrainCible;
    PersonnageEnum emeteur;
    PersonnageEnum cible;
    TypeAction typeAction;
    OptionEnum optionEnum;

    public ActionAbstract(TerrainEnum terrainCible, PersonnageEnum emeteur, PersonnageEnum cible, TypeAction typeAction, OptionEnum option) {
        this.terrainCible = terrainCible;
        this.emeteur = emeteur;
        this.cible = cible;
        this.typeAction = typeAction;
        this.optionEnum = option;
    }

    abstract void apply(Partie partie);

}
