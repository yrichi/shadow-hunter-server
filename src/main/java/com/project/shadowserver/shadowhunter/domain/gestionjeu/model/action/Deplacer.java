package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.TerrainEnum;

public class Deplacer extends ActionAbstract {


    public Deplacer(TerrainEnum terrainCible, PersonnageEnum emeteur, PersonnageEnum cible, TypeAction typeAction, OptionEnum option) {
        super(terrainCible, emeteur, cible, typeAction, option);
    }

    @Override
    void apply(Partie partie) {

    }
}
