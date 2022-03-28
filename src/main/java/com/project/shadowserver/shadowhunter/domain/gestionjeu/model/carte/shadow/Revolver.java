package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.shadow;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.RevolverEquipement;

public class Revolver extends AbstractCarte {

    public Revolver(){
        this.setNomCarteEnum(NomCarteEnum.REVOLVER);
        this.setTypeEquipement(new RevolverEquipement());
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
