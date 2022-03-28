package com.project.shadowserver.shadowhunter.domain.utilisateur;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurServiceImpl implements UtilisateurService {

    private final UtilisateurProvider utilisateurProvider;

    @Override
    public boolean existsByUsername(String username) {
        return utilisateurProvider.existsByUsername(username);
    }

    @Override
    public UtilisateurModel save(UtilisateurModel utilisateur) {
        return utilisateurProvider.save(utilisateur);
    }
}
