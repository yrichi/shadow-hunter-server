package com.project.shadowserver.shadowhunter.domain.gestionjeu;

import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.action.Action;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.Option;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.option.OptionFactory;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.provider.PartieProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class GestionPartieImpl implements GestionPartie {

    private final PartieProvider partieProvider;


    @Override
    public Partie creerPartie(String idJoueur) {
        Partie partie = new Partie();
        partie.initPartie(idJoueur);
        return partieProvider.createPartie(partie);
    }

    @Override
    public Partie commencerPartie(String idPartie, String idJoueur) {
        var partie = partieProvider.getPartie(idPartie);
        partie.commencerPartie();
        partie.setJoueurEnCours(idJoueur);
        var partieSaved = partieProvider.savePartie(idPartie, partie);
        return partieSaved.getPartie(idJoueur);
    }

    @Override
    public List<Option> getOptionJoueurs(String idPartie, String idJoueur) {
        return getPartie(idPartie, idJoueur).getOptions(idJoueur).stream().map(OptionFactory::buildOption).collect(Collectors.toList());
    }

    @Override
    public Partie applyAction(String idPartie, String idJoueur, Action action) {
        Partie partie = partieProvider.getPartie(idPartie);
        partie.applyAction(action);
        return partieProvider.savePartie(idPartie,partie);
    }

    @Override
    public Partie getPartie(String idPartie, String joueurId) {
        return partieProvider.getPartie(idPartie).getPartie(idPartie);
    }


    private Partie rejoindrePartie(String idPartie, String idJoueur) {
        var partie = partieProvider.getPartie(idPartie);
        partie.rejoindrePartie(idJoueur);
        return partieProvider.savePartie(idPartie, partie).getPartie(idJoueur);
    }

}
