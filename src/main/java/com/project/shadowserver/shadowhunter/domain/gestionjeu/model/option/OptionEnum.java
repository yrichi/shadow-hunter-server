package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;


public enum OptionEnum {
    // Option par defaut

    DEPLACER("Se deplacer"),
    ATTAQUER("Attaquer"),

    SE_REVELER("Se reveler"),

    PAS_SE_REVELER("Ne pas se reveler"),

    CHOISIR_JOUEUR("choisir un joueur"),

    SUBIR_BLESSURE("Subir une blessure"),

    DONNER_CARTE_EQUIPEMENT("donner une carte equipement");

    public String getLabel() {
        return label;
    }

    final String label;


    OptionEnum(String label) {
        this.label = label;
    }
}
