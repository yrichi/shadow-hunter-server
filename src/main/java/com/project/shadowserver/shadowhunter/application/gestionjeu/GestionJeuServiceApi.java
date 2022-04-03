package com.project.shadowserver.shadowhunter.application.gestionjeu;

import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.ActionPresentation;
import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.OptionPresentation;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/gestion-jeu")
public interface GestionJeuServiceApi {

    @GetMapping("{idPartie}/{joueurId}/options")
    List<OptionPresentation> getOption(@PathVariable String idPartie,@PathVariable String joueurId);

    @PostMapping("{idPartie}/{joueurId}/action")
    void action(@PathVariable String joueurId, @PathVariable String idPartie, @RequestBody ActionPresentation actionPresentation);


}
