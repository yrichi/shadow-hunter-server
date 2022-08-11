package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurModel;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Data
@Builder
public class Joueur {
    private int nbBlessure;
    private String idUtilisateur;
    private CartePersonnageAbstract cartePersonnage;
    private TerrainEnum positionTerrain;
    private boolean standby;
    private Set<OptionEnum> options = new HashSet<>();
    private List<Notification> notifications = new ArrayList<>();


    public boolean isDead() { return nbBlessure >= cartePersonnage.getNombreDePointDeVie();
    }


    public void initOptionsNewTurn() {
        options.addAll(List.of(OptionEnum.SE_REVELER,OptionEnum.DEPLACER));
    }
}
