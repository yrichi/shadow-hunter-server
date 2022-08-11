package com.project.shadowserver.shadowhunter.domain.gestionjeu.provider;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PartieProviderImpl implements PartieProvider {

    static int idPartieIncrement = 0;
    private Map<String, Partie> parties = new HashMap<>();

    @Override
    public Partie createPartie(Partie partieToCreate) {
        partieToCreate.setIdPartie(String.valueOf(idPartieIncrement));
        idPartieIncrement++;
        this.parties.put(partieToCreate.getIdPartie(), partieToCreate);
        return this.parties.get(partieToCreate.getIdPartie());
    }

    @Override
    public Partie getPartie(String idPartie) {
        return parties.get(idPartie);
    }

    @Override
    public Partie savePartie(String idPartie, Partie partie) {
        return parties.put(idPartie,partie);
    }
}
