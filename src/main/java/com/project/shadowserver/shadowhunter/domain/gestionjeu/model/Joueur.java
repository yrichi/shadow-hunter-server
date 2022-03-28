package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.CartePersonnageAbstract;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;
import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class Joueur {
    int nbBlessure;
    CartePersonnageAbstract cartePersonnage;
    TerrainEnum positionTerrain;
    boolean standby;
    List<Option> options = new ArrayList<>();
    List<Notification> notifications = new ArrayList<>();


    public boolean isDead() { return nbBlessure >= cartePersonnage.getNombreDePointDeVie();
    }


}
