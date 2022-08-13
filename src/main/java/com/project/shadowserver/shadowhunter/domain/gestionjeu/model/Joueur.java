package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeEquipementEffectEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.util.DiceRollUtil;
import lombok.Builder;
import lombok.Data;
import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Builder
@Log4j2
public class Joueur {
    private int nbBlessure;
    private String idUtilisateur;
    private CartePersonnageAbstract cartePersonnage;
    private TerrainEnum positionTerrain;
    private boolean standby;
    private Set<OptionEnum> options = new HashSet<>();
    private List<Notification> notifications = new ArrayList<>();
    private List<AbstractCarte> equipements = new ArrayList<>();
    private Boolean isWin;


    public boolean isDead() {
        return nbBlessure >= cartePersonnage.getNombreDePointDeVie();
    }


    public void initOptionsNewTurn() {
        options.addAll(List.of(OptionEnum.SE_REVELER, OptionEnum.DEPLACER));
    }

    public boolean isNotVunerableForetHante() {
        return equipements.stream().anyMatch(abstractCarte -> abstractCarte.getNomCarteEnum().equals(NomCarteEnum.ANGE_GARDIEN) ||
                abstractCarte.getNomCarteEnum().equals(NomCarteEnum.BROCHE_DE_CHANCE));
    }

    public void blesse(int nbBlessure) {
        this.nbBlessure += nbBlessure;
        if (this.nbBlessure <= cartePersonnage.getNombreDePointDeVie()) {
        } else {
            notifications.add(
                    NotificationFactory.buildNotification(
                            TypeNotificationEnum.INFORMATIF, idUtilisateur, String.format("le personnage %s est mort", cartePersonnage.getPersonnageEnum())));
        };
    }

    public void soigner(int nbPtSoin) {
        if (nbPtSoin <= nbBlessure) {
            this.nbBlessure -= nbPtSoin;
        } else {
            this.nbBlessure = 0;
        }
    }

    public void transfertCarteEquipement(Joueur joueurCible, NomCarteEnum carteCible) {
        if(isEquipmentExist(carteCible)){
            equipements = equipements.stream().filter(abstractCarte -> !abstractCarte.getNomCarteEnum().equals(carteCible)).collect(Collectors.toList());
            joueurCible.equipements.add(CarteFactory.getCarte(carteCible));
        } else {
            log.debug("on tente de donner/voler un equipement qui n'existe pas ! ",joueurCible,carteCible);
        };


    }

    public boolean isEquipmentExist(NomCarteEnum carte) {
        return equipements.stream().anyMatch(abstractCarte -> abstractCarte.getNomCarteEnum().equals(carte));
    }

    public void ajouterEquipement(AbstractCarte carte) {
        equipements.add(carte);
    }

    public void removeEquipement(NomCarteEnum carteCible) {
        equipements = equipements.stream().filter(abstractCarte -> !abstractCarte.getNomCarteEnum().equals(carteCible)).collect(Collectors.toList());
    }

    public void attaque( Joueur joueurCible) {
        if (joueurCible.getIdUtilisateur().equals(getIdUtilisateur())){
            // le joueur ne peux pas s'auto attaquer, meme avec la metraillette
            return;
        }
        int lancesDeDes;
        if (isEquipmentExist(NomCarteEnum.SABRE_MASAMURE)){
            lancesDeDes = DiceRollUtil.diceRoll(TypeDesEnum.DES_4);
        } else {
            lancesDeDes = DiceRollUtil.diceRoll(TypeDesEnum.DOUBLE_DES_6);
        }
        int degatsInfligeBrut = equipements.stream().filter(abstractCarte -> abstractCarte.getTypeEquipement() != null && abstractCarte.getTypeEquipement().getTypeEquipementEffectEnum().contains(TypeEquipementEffectEnum.EFFET_ATTAQUE))
                .map(abstractCarte -> abstractCarte.getTypeEquipement().getDamagesEmitted(lancesDeDes)).reduce(0,Integer::sum);
        int degatRecu = joueurCible.degatRecu(degatsInfligeBrut);

        manageCapaciteSpecial(degatRecu,joueurCible);

        joueurCible.blesse(degatRecu);
    }

    private void manageCapaciteSpecial(int degatRecu, Joueur joueurCible) {
        // TODO ajouter dans les personnages les options types vampire , si degat alors heal vampire


        // TODO ajouter pour les personnages cible, les options type loup garou =>  si degat recu alors le loup garou peut attaquer
    }

    private int degatRecu(int lanceDes){
        return equipements.stream().filter(abstractCarte -> abstractCarte.getTypeEquipement() != null && abstractCarte.getTypeEquipement().getTypeEquipementEffectEnum().contains(TypeEquipementEffectEnum.EFFET_DEFENSE))
                .map(abstractCarte -> abstractCarte.getTypeEquipement().getDamagesReceived(lanceDes)).reduce(0,Integer::sum);

    }
}
