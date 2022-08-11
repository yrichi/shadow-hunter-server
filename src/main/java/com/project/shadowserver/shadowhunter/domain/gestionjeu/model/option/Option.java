package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option;


import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.equipement.TypeDesEnum;
import lombok.Builder;
import lombok.Data;
@Data
@Builder
public class Option {
    private OptionEnum optionEnum;
    private Boolean isRequired = false;
    private TypeCibleEnum typeCible;
}
