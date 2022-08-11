package com.project.shadowserver.shadowhunter.application.gestionjeu;

import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.in.ActionPresentation;
import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.out.OptionPresentation;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.GestionPartie;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
public class GestionJeuController implements GestionJeuServiceApi {

    private final GestionPartie gestionPartie;

    @Override
    public List<OptionPresentation> getOption(String joueurId, String idPartie) {
        return gestionPartie.getOptionJoueurs(idPartie, joueurId).stream().map(OptionPresentation::new).
                collect(Collectors.toList());
    }

    @Override
    public void action(String joueurId, String idPartie, ActionPresentation actionPresentation) {
        gestionPartie.applyAction(joueurId, joueurId, actionPresentation.toDomain());
    }

    @Override
    public Partie getPartie(String idPartie, String joueurId) {
        return gestionPartie.getPartie(idPartie, joueurId);
    }

    @Override
    public Partie createPartie(String joueurId, int nbJoueur) {
        return gestionPartie.creerPartie(joueurId);
    }

}
