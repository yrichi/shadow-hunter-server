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
    SOIGNER_BLESSURE("Soigner une blessure"),
    SUBIR_DEUX_BLESSURE("Subir deux blessures"),
    DONNER_CARTE_EQUIPEMENT("donner une carte equipement"),

    VOLER_CARTE_EQUIPEMENT("donner une carte equipement"),
    CHOISIR_CARTE_VISION("Choisir carte vision"),
    CHOISIR_CARTE_BLANCHE("Choisir carte blanche"),
    CHOISIR_CARTE_TENEBRE("Choisir carte tenebre"),

    // BOB
    VOLER_EQUIPEMENT("voler un equipement");

    private final String label;


}
