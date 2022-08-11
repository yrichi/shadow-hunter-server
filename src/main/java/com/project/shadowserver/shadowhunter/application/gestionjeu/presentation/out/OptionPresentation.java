package com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.out;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.TypeCibleEnum;
import lombok.AllArgsConstructor;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;

@AllArgsConstructor
public class OptionPresentation {
    private OptionEnum optionEnum;
    private Boolean isRequired;
    private TypeCibleEnum typeCibleEnum;

    public OptionPresentation(Option option){
        optionEnum = option.getOptionEnum();
        isRequired = option.getIsRequired();
        typeCibleEnum = option.getTypeCible();
    }
}
