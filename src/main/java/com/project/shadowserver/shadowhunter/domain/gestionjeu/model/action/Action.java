package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.util.DiceRollUtil;
import lombok.Data;

@Data
public class Action {
    TerrainEnum terrainCible;
    String idJoueurEmeteur;
    String idJoueurCible;
    OptionEnum optionEnum;

    public Action(TerrainEnum terrainCible, String emeteur, String cible, OptionEnum option) {
        this.terrainCible = terrainCible;
        this.idJoueurEmeteur = emeteur;
        this.idJoueurCible = cible;
        this.optionEnum = option;
    }

    public void apply(Partie partie){
        var joueurEmeteur = partie.getPersonnage(getIdJoueurEmeteur());
        switch (optionEnum) {
            case DEPLACER:
                partie.deplacement(getIdJoueurEmeteur());
                break;
            case DEPLACER_VERS_TERRAIN:
                partie.deplacement(getIdJoueurEmeteur(),terrainCible);
                break;
            case ATTAQUER:
                partie.attaquer(idJoueurEmeteur,idJoueurCible);
                break;
            case SE_REVELER:
                break;
            case UTILISER_POUVOIR:
                break;
            case CHOISIR_JOUEUR:
                break;
            case SUBIR_BLESSURE:
                break;
            case SOIGNER_BLESSURE:
                break;
            case SUBIR_DEUX_BLESSURE:
                break;
            case DONNER_CARTE_EQUIPEMENT:
                break;
            case VOLER_CARTE_EQUIPEMENT:
                break;
            case CHOISIR_CARTE_VISION:
                break;
            case CHOISIR_CARTE_BLANCHE:
                break;
            case CHOISIR_CARTE_TENEBRE:
                break;
            case VOLER_EQUIPEMENT:
                break;
        }
    };

}
