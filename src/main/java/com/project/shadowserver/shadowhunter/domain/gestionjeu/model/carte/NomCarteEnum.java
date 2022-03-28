package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public enum NomCarteEnum {
    // carte vison
    VISION_CLAIRVOYANTE(TypeCarteEnum.VISION),
    VISION_CUPIDE(TypeCarteEnum.VISION),
    VISION_DESTRUCTRICE(TypeCarteEnum.VISION),
    VISION_DIVINE(TypeCarteEnum.VISION),
    VISION_ENIVRANTE(TypeCarteEnum.VISION),
    VISION_FOUDROYANTE(TypeCarteEnum.VISION),
    VISION_FURTIVE(TypeCarteEnum.VISION),
    VISION_LUGUBRE(TypeCarteEnum.VISION),
    VISION_MORTIERE(TypeCarteEnum.VISION),
    VISION_PURIFICATRICE(TypeCarteEnum.VISION),
    VISION_RECONFORTANTE(TypeCarteEnum.VISION),
    VISION_SUPREME(TypeCarteEnum.VISION),
    // carte lumiere
    AMULETTE(TypeCarteEnum.LUMIERE),
    ANGE_GARDIEN(TypeCarteEnum.LUMIERE),
    BENEDICTION(TypeCarteEnum.LUMIERE),
    BOUSSOLE(TypeCarteEnum.LUMIERE),
    BROCHE_DE_CHANCE(TypeCarteEnum.LUMIERE),
    CHOCOLAT(TypeCarteEnum.LUMIERE),
    CRUCIFIX_EN_ARGENT(TypeCarteEnum.LUMIERE),
    EAU_BENITE(TypeCarteEnum.LUMIERE),
    ECLAIR_PURIFICATEUR(TypeCarteEnum.LUMIERE),
    LANCE(TypeCarteEnum.LUMIERE),
    MIROIR_DIVIN(TypeCarteEnum.LUMIERE),
    PREMIER_SECOURS(TypeCarteEnum.LUMIERE),
    SAVOIR_ANCESTRAL(TypeCarteEnum.LUMIERE),
    AVENEMENT_SUPREME(TypeCarteEnum.LUMIERE),
    TOGE_SAINTE(TypeCarteEnum.LUMIERE),
    // carte shadow
    ARAIGNEE_SANGUINAIRE(TypeCarteEnum.TENEBRE),
    CHAUVE_SOURIS(TypeCarteEnum.TENEBRE),
    DYNAMITE(TypeCarteEnum.TENEBRE),
    HACHE_TUEUSE(TypeCarteEnum.TENEBRE),
    HACHOIR_MAUDIT(TypeCarteEnum.TENEBRE),
    MITRAILLETTE_FUNESTE(TypeCarteEnum.TENEBRE),
    PEAU_DE_BANANE(TypeCarteEnum.TENEBRE),
    POUPEE_DEMONIAQUE(TypeCarteEnum.TENEBRE),
    REVOLVER(TypeCarteEnum.TENEBRE),
    RITUEL_DIABOLIQUE(TypeCarteEnum.TENEBRE),
    SABRE_MASAMURE(TypeCarteEnum.TENEBRE),
    SUCCUBE_TENTATRICE(TypeCarteEnum.TENEBRE),
    TRONCONNEUSE_DU_MAL(TypeCarteEnum.TENEBRE);

    public final TypeCarteEnum typeCarte;


    public static List<NomCarteEnum> getCartes(TypeCarteEnum typeCarteEnum){
        return Arrays.stream(values()).filter(nomCarteEnum -> typeCarteEnum.equals(nomCarteEnum.typeCarte)).collect(Collectors.toList());
    }

    NomCarteEnum(TypeCarteEnum vision) {
        this.typeCarte = vision;
    }
}
