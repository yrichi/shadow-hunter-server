package com.project.shadowserver.shadowhunter.domain.utilisateur;

public interface UtilisateurService {

    boolean existsByUsername(String username);

    UtilisateurModel save(UtilisateurModel toDomain);
}
