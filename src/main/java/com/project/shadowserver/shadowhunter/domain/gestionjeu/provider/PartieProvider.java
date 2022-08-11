package com.project.shadowserver.shadowhunter.domain.gestionjeu.provider;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;

public interface PartieProvider {
    Partie createPartie(Partie partieEnCours);

    Partie getPartie(String idPartie);

    Partie savePartie(String idPartie, Partie partie);
}
