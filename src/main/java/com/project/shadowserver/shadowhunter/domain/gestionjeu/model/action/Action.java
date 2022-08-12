package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.TypeCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Data;

@Data
public class Action {
    TerrainEnum terrainCible;
    String idJoueurEmeteur;
    String idJoueurCible;

    NomCarteEnum carteCible;
    OptionEnum optionEnum;

    public Action(TerrainEnum terrainCible, String emeteur, String cible, OptionEnum option,NomCarteEnum carteCible) {
        this.terrainCible = terrainCible;
        this.idJoueurEmeteur = emeteur;
        this.idJoueurCible = cible;
        this.carteCible = carteCible;
        this.optionEnum = option;
    }

    public void apply(Partie partie){
        switch (optionEnum) {
            case DEPLACER:
                partie.deplacement(getIdJoueurEmeteur());
                break;
            case DEPLACER_VERS_TERRAIN:
                partie.deplacement(getIdJoueurEmeteur(),terrainCible);
                break;
            case ATTAQUER:
                partie.attaquer(idJoueurEmeteur,idJoueurCible,terrainCible);
                break;
            case SE_REVELER:
                partie.seReveler(idJoueurEmeteur);
                break;
            case UTILISER_POUVOIR:
                partie.utiliserPouvoir(idJoueurEmeteur,idJoueurCible);
                break;
            case CHOISIR_JOUEUR:
                partie.utiliserCarte(idJoueurEmeteur,idJoueurCible, carteCible);
                break;
            case SOIGNER_BLESSURE_FORET_HANTE:
                partie.soignerBlessureForetHante(idJoueurEmeteur,idJoueurCible);
                break;
            case SUBIR_BLESSURE_FORET_HANTE:
                partie.subirBlessureForetHante(idJoueurEmeteur,idJoueurCible);
                break;
            case DONNER_CARTE_EQUIPEMENT:
                partie.donnerEquipement(idJoueurEmeteur,idJoueurCible,carteCible);
                break;
            case VOLER_CARTE_EQUIPEMENT:
                partie.volerEquipement(idJoueurEmeteur,idJoueurCible,carteCible);
                break;
            case CHOISIR_CARTE_VISION:
                partie.choisirCarte(idJoueurEmeteur, TypeCarteEnum.VISION);
                break;
            case CHOISIR_CARTE_BLANCHE:
                partie.choisirCarte(idJoueurEmeteur, TypeCarteEnum.LUMIERE);
                break;
            case CHOISIR_CARTE_TENEBRE:
                partie.choisirCarte(idJoueurEmeteur, TypeCarteEnum.TENEBRE);
                break;
            case VOLER_EQUIPEMENT:
                break;
        }
    };

}
