package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.personnage;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import lombok.Data;

@Data
public abstract class PouvoirAbstract {
    boolean utilisationUnique;
    abstract public void effetPouvoir(PersonnageEnum personnageEmeteur, Partie partie, PersonnageEnum personnageRecepteur);
}
