package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.personnages;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NotificationFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.TypeNotificationEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.RoleEnum;

import java.util.List;

public class LoupGarou extends CartePersonnageAbstract {

    public LoupGarou() {
        this.setPersonnageEnum(PersonnageEnum.LOUP_GAROU);
        this.setNombreDePointDeVie(14);
        this.setRole(RoleEnum.SHADOW);
    }

    @Override
    public void usePower(Joueur joueurEmeteur, Joueur joueurCible, Partie partie, int degat) {
        if (joueurCible.getCartePersonnage().getPersonnageEnum().equals(getPersonnageEnum())) {
            // je suis donc la cible d'une attaque
            var option = OptionFactory.buildOption(OptionEnum.CONTRE_ATTAQUE, List.of(joueurEmeteur.getCartePersonnage().getPersonnageEnum()));
            joueurCible.getOptions().add(option);
            joueurCible.getNotifications().add(
                    NotificationFactory.buildNotification(
                            TypeNotificationEnum.ATTAQUE,
                            joueurCible.getIdUtilisateur(),
                            "vous venez de subir une attaque, mais vous etes un loup garou, vous pouvez contre attaquer ! ")
            );
            partie.getWaitingJoueursAction().add(joueurCible);
        }
    }

    @Override
    public boolean conditionDeVictoire(Partie partie) {
        return false;
    }

    @Override
    public boolean canUsePower() {
        return false;
    }
}
