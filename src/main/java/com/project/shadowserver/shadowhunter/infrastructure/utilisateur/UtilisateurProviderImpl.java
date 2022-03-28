package com.project.shadowserver.shadowhunter.infrastructure.utilisateur;

import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurModel;
import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurProvider;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class UtilisateurProviderImpl implements UtilisateurProvider {

    private final UtilisateurRepository utilisateurRepository;

    @Override
    public UtilisateurEntity getUtilisateur(long id) {
        return utilisateurRepository.getById(id);
    }

    @Override
    public UtilisateurEntity updateUtilisateur(UtilisateurModel utilisateurModel) {
        return utilisateurRepository.save(UtilisateurEntity.fromDomain(utilisateurModel));
    }

    @Override
    public void deleteUtilisateur(long id) {
        utilisateurRepository.deleteById(id);
    }

    @Override
    public List<UtilisateurModel> getUtilisateurs() {
        return utilisateurRepository.findAll().stream().map(UtilisateurEntity::toDomain).collect(Collectors.toList());
    }

    @Override
    public Optional<UtilisateurModel> findByUsername(String username) {
        return Optional.of(utilisateurRepository.findByNom(username).toDomain());
    }

    @Override
    public boolean existsByUsername(String username) {
        return utilisateurRepository.existsByNom(username);
    }

    @Override
    public UtilisateurModel save(UtilisateurModel utilisateur) {
        return utilisateurRepository.save(UtilisateurEntity.fromDomain(utilisateur)).toDomain();
    }


}
