package com.project.shadowserver.shadowhunter.application.gestionjeu;

import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.ActionPresentation;
import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.OptionPresentation;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.GestionPartie;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GestionJeuServiceImpl implements GestionJeuServiceApi {

    private final GestionPartie gestionPartie;

    @Override
    public List<OptionPresentation> getOption(String joueurId) {
        return null;
    }

    @Override
    public void action(String joueurId, ActionPresentation actionPresentation) {

    }
}
