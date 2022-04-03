package com.project.shadowserver.shadowhunter.domain.gestionjeu.provider;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import org.springframework.stereotype.Service;

@Service
public class PartieProviderImpl implements PartieProvider {


    private Partie partieEnCours;

    @Override
    public void setPartieEnCours(Partie partieEnCours) {
        this.partieEnCours = partieEnCours;
    }

    @Override
    public Partie getPartie(){
        return partieEnCours;
    }
}
