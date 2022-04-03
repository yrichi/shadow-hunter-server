package com.project.shadowserver.shadowhunter.domain.gestionjeu.provider;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;

public interface PartieProvider {
    void setPartieEnCours(Partie partieEnCours);

    Partie getPartie();
}
