package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OptionEnum {

    // Option par defaut
    DEPLACER("Se deplacer"),

    DEPLACER_VERS_TERRAIN("Se deplacer vers le terrain de votre choix"),
    ATTAQUER("Attaquer"),
    SE_REVELER("Se reveler"),

    UTILISER_POUVOIR("utiliser pouvoir personnage"),
    CHOISIR_JOUEUR("choisir un joueur"),
    SUBIR_BLESSURE("Subir une blessure"),
    SOIGNER_BLESSURE_FORET_HANTE("Soigner une blessure"),
    SUBIR_BLESSURE_FORET_HANTE("Subir deux blessures"),
    DONNER_CARTE_EQUIPEMENT("donner une carte equipement"),

    VOLER_CARTE_EQUIPEMENT("voler une carte equipement"),
    CHOISIR_CARTE_VISION("Choisir carte vision"),
    CHOISIR_CARTE_BLANCHE("Choisir carte blanche"),
    CHOISIR_CARTE_TENEBRE("Choisir carte tenebre");

    private final String label;


}
