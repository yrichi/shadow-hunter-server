package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public abstract class OptionFactory {


    public static Option buildOption(OptionEnum option) {

        switch (option) {
            case ATTAQUER:
                return new Option(OptionEnum.ATTAQUER, false,TypeCibleEnum.JOUEUR);
            case DEPLACER:
                return new Option(OptionEnum.DEPLACER, true,TypeCibleEnum.TERRAIN);
            case SE_REVELER:
                return new Option(OptionEnum.SE_REVELER, false,TypeCibleEnum.SOI_MEME);
            case CHOISIR_JOUEUR:
                return new Option(OptionEnum.CHOISIR_JOUEUR, false,TypeCibleEnum.JOUEUR);
            case SUBIR_BLESSURE:
                return new Option(OptionEnum.SUBIR_BLESSURE, false,TypeCibleEnum.JOUEUR);
            case SUBIR_BLESSURE_FORET_HANTE:
                return new Option(OptionEnum.SUBIR_BLESSURE_FORET_HANTE, false,TypeCibleEnum.JOUEUR);
                case SOIGNER_BLESSURE_FORET_HANTE:
                return new Option(OptionEnum.SOIGNER_BLESSURE_FORET_HANTE, false,TypeCibleEnum.SOI_MEME);
            case DONNER_CARTE_EQUIPEMENT:
                return new Option(OptionEnum.DONNER_CARTE_EQUIPEMENT, false,TypeCibleEnum.JOUEUR);
            case CHOISIR_CARTE_VISION:
                return new Option(OptionEnum.CHOISIR_CARTE_VISION, false,TypeCibleEnum.SOI_MEME);
            case CHOISIR_CARTE_BLANCHE:
                return new Option(OptionEnum.CHOISIR_CARTE_BLANCHE, false,TypeCibleEnum.SOI_MEME);
            case CHOISIR_CARTE_TENEBRE:
                return new Option(OptionEnum.CHOISIR_CARTE_TENEBRE, false,TypeCibleEnum.SOI_MEME);
            default:
                // TODO ajouter exception
                return null;

        }

    }
}
