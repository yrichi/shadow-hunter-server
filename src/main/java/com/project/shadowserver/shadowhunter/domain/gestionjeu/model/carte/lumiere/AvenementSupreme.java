package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.lumiere;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;

public class AvenementSupreme extends AbstractCarte {

    public AvenementSupreme() {
        this.setNomCarteEnum(NomCarteEnum.AVENEMENT_SUPREME);
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
