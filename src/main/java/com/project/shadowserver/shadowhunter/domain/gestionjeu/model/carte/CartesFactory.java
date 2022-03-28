package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;


import java.util.List;
import java.util.stream.Collectors;

public class CartesFactory {

    static List<AbstractCarte> getCartes(TypeCarteEnum typeCarteEnum) {
        return NomCarteEnum.getCartes(typeCarteEnum).stream().map(CarteFactory::getCarte).collect(Collectors.toList());
    }

}
