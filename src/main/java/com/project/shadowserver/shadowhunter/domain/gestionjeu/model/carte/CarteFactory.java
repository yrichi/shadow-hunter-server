package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.lumiere.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.shadow.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.vision.*;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CarteFactory {

    public static AbstractCarte getCarte(NomCarteEnum nomCarteEnum){
        // TODO pour l'instant en mode bourrin mais il faudrait deplacer la condition d'initialisation coté implementation des AbstractCarte et faire une loop
        // comme ici https://stackoverflow.com/questions/6390810/implement-a-simple-factory-pattern-with-spring-3-annotations
        switch (nomCarteEnum){
            case VISION_CLAIRVOYANTE:
                new VisionClairvoyante();
            case VISION_CUPIDE:
                new VisionCupide();
            case VISION_DESTRUCTRICE:
                new VisionDestructice();
            case VISION_DIVINE:
                new VisionDivine();
            case VISION_ENIVRANTE:
                new VisionEnivrante();
            case VISION_FOUDROYANTE:
                new VisionFoudroyante();
            case VISION_FURTIVE:
                new VisionFurtive();
            case VISION_LUGUBRE:
                new VisionLugubre();
            case VISION_MORTIERE:
                new VisionMortifiere();
            case VISION_PURIFICATRICE:
                new VisionPurificatrice();
            case VISION_RECONFORTANTE:
                new VisionReconfortante();
            case VISION_SUPREME:
                new VisionSupreme();

            case AMULETTE:
                new Amulette();
            case ANGE_GARDIEN:
                new AngeGardien();
            case BENEDICTION:
                new Benediction();
            case BOUSSOLE:
                new BoussoleMystique();
            case BROCHE_DE_CHANCE:
                new BrocheDeChance();
            case CHOCOLAT:
                new Chocolat();
            case CRUCIFIX_EN_ARGENT:
                new CrucifixEnArgent();
            case EAU_BENITE:
                new EauBenite();
            case ECLAIR_PURIFICATEUR:
                new EclairPurificateur();
            case LANCE:
                new Lance();
            case MIROIR_DIVIN:
                new MiroirDivin();
            case PREMIER_SECOURS:
                new PremierSecours();
            case SAVOIR_ANCESTRAL:
                new SavoirAncestral();
            case AVENEMENT_SUPREME:
                new AvenementSupreme();
            case TOGE_SAINTE:
                new TogeSainte();


            case ARAIGNEE_SANGUINAIRE:
                new AraigneeSanguinaire();
            case CHAUVE_SOURIS:
                new ChauveSourisVampire();
            case DYNAMITE:
                new Dynamite();
            case HACHE_TUEUSE:
                new HacheTueuse();
            case HACHOIR_MAUDIT:
                new HachoirMaudit();
            case MITRAILLETTE_FUNESTE:
                new MitrailleuseFuneste();
            case PEAU_DE_BANANE:
                new PeauDeBanane();
            case POUPEE_DEMONIAQUE:
                new PoupeeDemoniaque();
            case REVOLVER:
                new Revolver();
            case RITUEL_DIABOLIQUE:
                new RituelDiabolique();
            case SABRE_MASAMURE:
                new SabreMasamure();
            case SUCCUBE_TENTATRICE:
                new SuccubeTentatrice() ;
            case TRONCONNEUSE_DU_MAL:
                new TronconneuseDuMal();
        }
        log.error("aucune implementation valide pour initialiser une carte");
        return null;
    }
}
