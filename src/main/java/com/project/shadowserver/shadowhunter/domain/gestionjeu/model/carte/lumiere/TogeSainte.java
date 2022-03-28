package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.lumiere;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TogeSainteEquipement;

public class TogeSainte extends AbstractCarte {


    public TogeSainte() {
        this.setNomCarteEnum(NomCarteEnum.TOGE_SAINTE);
        this.setTypeEquipement(new TogeSainteEquipement());
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
