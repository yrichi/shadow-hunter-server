package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

import java.util.Collections;
import java.util.List;

@Data
public abstract class OptionFactory {


    public static Option buildOption(OptionEnum option) {
        return buildOption(option, Collections.emptyList(), Collections.emptyList());
    }


    public static Option buildOption(OptionEnum option, List<PersonnageEnum> personnageCible) {
        return buildOption(option, Collections.emptyList(), personnageCible);
    }

    public static Option buildOption(OptionEnum option, List<TerrainEnum> terrainsCible, List<PersonnageEnum> personnagesCible) {

        switch (option) {
            case ATTAQUER:
                return new Option(OptionEnum.ATTAQUER, false, terrainsCible, personnagesCible);
            case DEPLACER:
                return new Option(OptionEnum.DEPLACER, true, terrainsCible, personnagesCible);
            case SE_REVELER:
                return new Option(OptionEnum.SE_REVELER, false, terrainsCible, personnagesCible);
            case CHOISIR_JOUEUR:
                return new Option(OptionEnum.CHOISIR_JOUEUR, false, terrainsCible, personnagesCible);
            case SUBIR_BLESSURE:
                return new Option(OptionEnum.SUBIR_BLESSURE, false, terrainsCible, personnagesCible);
            case SUBIR_BLESSURE_FORET_HANTE:
                return new Option(OptionEnum.SUBIR_BLESSURE_FORET_HANTE, false, terrainsCible, personnagesCible);
            case SOIGNER_BLESSURE_FORET_HANTE:
                return new Option(OptionEnum.SOIGNER_BLESSURE_FORET_HANTE, false, terrainsCible, personnagesCible);
            case DONNER_CARTE_EQUIPEMENT:
                return new Option(OptionEnum.DONNER_CARTE_EQUIPEMENT, false, terrainsCible, personnagesCible);
            case CHOISIR_CARTE_VISION:
                return new Option(OptionEnum.CHOISIR_CARTE_VISION, false, terrainsCible, personnagesCible);
            case CHOISIR_CARTE_BLANCHE:
                return new Option(OptionEnum.CHOISIR_CARTE_BLANCHE, false, terrainsCible, personnagesCible);
            case CHOISIR_CARTE_TENEBRE:
                return new Option(OptionEnum.CHOISIR_CARTE_TENEBRE, false, terrainsCible, personnagesCible);
            case CONTRE_ATTAQUE:
                return new Option(OptionEnum.CONTRE_ATTAQUE, false, terrainsCible, personnagesCible);
            default:
                // TODO ajouter exception
                return null;

        }

    }
}
