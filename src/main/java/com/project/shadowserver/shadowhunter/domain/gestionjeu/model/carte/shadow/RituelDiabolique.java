package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.shadow;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Joueur;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.AbstractCarte;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.NomCarteEnum;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte.Notification;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionEnum;

import java.util.List;

public class RituelDiabolique extends AbstractCarte {

    public RituelDiabolique() {
        this.setNomCarteEnum(NomCarteEnum.RITUEL_DIABOLIQUE);
        this.setOptions(initOptions());
    }

    private List<Option> initOptions() {
        return List.of(
                Option.builder().optionEnum(OptionEnum.SE_REVELER).build(),
                Option.builder().optionEnum(OptionEnum.PAS_SE_REVELER).build());
    }

    @Override
    public String getNotificationEffect() {
        return null;
    }

    @Override
    public Notification effetCarte(Joueur joueurEmeteur, Joueur joueurRecepteur, Partie partie) {
        return null;
    }
}
