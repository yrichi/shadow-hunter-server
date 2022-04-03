package com.project.shadowserver.shadowhunter.application.gestionjeu;

import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.ActionPresentation;
import com.project.shadowserver.shadowhunter.application.gestionjeu.presentation.OptionPresentation;
import com.project.shadowserver.shadowhunter.domain.gestionjeu.model.Partie;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RequestMapping("/gestion-jeu")
public interface GestionJeuServiceApi {

    @GetMapping("{idPartie}/options")
    List<OptionPresentation> getOption(@PathVariable String idPartie,@RequestParam String joueurId);

    @PostMapping("{idPartie}/{joueurId}/action")
    void action(@PathVariable String joueurId, @PathVariable String idPartie, @RequestBody ActionPresentation actionPresentation);

    @GetMapping("/partie/{idPartie}")
    Partie getPartie(@PathVariable String idPartie, @RequestParam String joueurId);

}
