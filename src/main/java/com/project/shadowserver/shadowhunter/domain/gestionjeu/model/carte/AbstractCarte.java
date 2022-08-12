package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeEquipementAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import lombok.Data;

import java.util.List;

@Data
public abstract class AbstractCarte {
    private Boolean hidden;
    private TypeEquipementAbstract typeEquipement;
    private NomCarteEnum nomCarteEnum;
    private Boolean isDefausse;
    private String idJoueurOwner;
    private List<PersonnageEnum> authorizedPersonnages;
    private List<Option> options;
    private Boolean used;

    public abstract String getNotificationEffect();

    public abstract Notification effetCarte(Joueur joueurEmeteur, Joueur joueurRecepteur, Partie partie);

    public Boolean isEquipement(){
        return this.getTypeEquipement() != null;
    }
}
