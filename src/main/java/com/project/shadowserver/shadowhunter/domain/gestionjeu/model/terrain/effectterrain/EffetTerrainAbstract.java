package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.terrain.effectterrain;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage.PersonnageEnum;
import lombok.Data;

@Data
public abstract class EffetTerrainAbstract {


    public abstract Notification useEffect(PersonnageEnum emeteur, PersonnageEnum recepteur, Partie partie);

}
