package com.project.shadowserver.shadowhunter.domain.utilisateur;

import com.project.shadowserver.shadowhunter.infrastructure.utilisateur.UtilisateurEntity;


import java.util.List;
import java.util.Optional;

public interface UtilisateurProvider {
    UtilisateurEntity getUtilisateur(long id);

    UtilisateurEntity updateUtilisateur(UtilisateurModel utilisateurModel);

    void deleteUtilisateur(long id);


    List<UtilisateurModel> getUtilisateurs();

    Optional<UtilisateurModel> findByUsername(String username);

    boolean existsByUsername(String username);

    UtilisateurModel save(UtilisateurModel utilisateur);
}
