package com.project.shadowserver.shadowhunter.infrastructure.utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurRepository extends JpaRepository<UtilisateurEntity, Long> {


    UtilisateurEntity findByNom(String username);

    boolean existsByNom(String username);
}
