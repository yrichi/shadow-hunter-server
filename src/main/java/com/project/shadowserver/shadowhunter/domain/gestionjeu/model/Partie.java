package com.project.shadowserver.shadowhunter.domain.gestionjeu.model;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.*;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.*;
import lombok.Data;
import java.util.List;

@Data
public class Partie {
    List<Joueur> joueurs;
    Boolean isEnd;
    List<TerrainAbstract> terrains;
    int JoueurActuel;
    List<AbstractCarte> carteShadows;
    List<AbstractCarte> carteLumiere;
    List<AbstractCarte> carteVision;
}
