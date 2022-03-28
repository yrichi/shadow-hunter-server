package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import lombok.Data;

import java.util.Date;

@Data
public abstract class CartePersonnageAbstract {
    PersonnageEnum personnageEnum;
    RoleEnum role;
    Boolean hidden;
    // permettra de gerer la carte vision supreme
    PersonnageEnum authorizedPersonnageSeeCard;
    // permettra de gerer le fait que la carte soit visible qu'un temps temporaire
    Date lastTimeSeenCard;
    PouvoirAbstract pouvoir;
    int nombreDePointDeVie;


    public abstract boolean conditionDeVictoire(Partie partie);

    public abstract boolean canUsePower();

    public abstract String usePower(PersonnageEnum personnageEmeteur, Partie partie, PersonnageEnum personnageRecepteur);
}
