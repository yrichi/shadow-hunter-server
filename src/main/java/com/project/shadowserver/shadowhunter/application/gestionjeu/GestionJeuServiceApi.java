package com.project.shadowserver.shadowhunter.application.gestionjeu;

import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.ActionPresentation;
import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.OptionPresentation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/gestion-jeu")
public interface GestionJeuServiceApi {

    @GetMapping("{joueurId}/options")
    List<OptionPresentation> getOption(@PathVariable String joueurId);

    @PostMapping("{joueurId}/action")
    void action(@PathVariable String joueurId, @RequestBody ActionPresentation actionPresentation);

}
