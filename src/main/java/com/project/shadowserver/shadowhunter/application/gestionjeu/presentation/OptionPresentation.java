package com.project.shadowserver.shadowhunter.application.gestionjeu.presentation;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class OptionPresentation {
    OptionEnum optionEnum;
    Boolean isRequired;
    TypeDesEnum typeDes;

}
