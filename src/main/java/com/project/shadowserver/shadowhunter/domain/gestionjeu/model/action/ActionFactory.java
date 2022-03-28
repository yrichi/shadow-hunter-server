package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public abstract class ActionFactory {


    ActionAbstract buildAction(TerrainEnum terrainCible, PersonnageEnum emeteur, PersonnageEnum cible, TypeAction typeAction, OptionEnum option) {

        switch (option) {
            case ATTAQUER:
                return new Attaque(terrainCible, emeteur, cible, typeAction, option);
            case DEPLACER:
                return new Deplacer(terrainCible, emeteur, cible, typeAction, option);
            default:
                return new Special(terrainCible, emeteur, cible, typeAction, option);

        }

    }
}
