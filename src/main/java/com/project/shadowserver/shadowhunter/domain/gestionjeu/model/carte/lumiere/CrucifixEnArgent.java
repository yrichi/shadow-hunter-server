package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.lumiere;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.CrucifixEnArgentEquipement;

public class CrucifixEnArgent extends AbstractCarte {

    public CrucifixEnArgent() {
        this.setNomCarteEnum(NomCarteEnum.CRUCIFIX_EN_ARGENT);
        this.setTypeEquipement(new CrucifixEnArgentEquipement());
    }

    @Override
    public String getNotificationEffect() {
        return null;
    }

    @Override
    public Notification effetCarte(Joueur joueurEmeteur, Joueur joueurRecepteur, Partie partie) {
        return null;
    }
}
