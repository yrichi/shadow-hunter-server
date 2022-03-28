package com.project.shadowserver.shadowhunter.infrastructure.utilisateur;


import com.project.shadowserver.shadowhunter.domain.utilisateur.UtilisateurModel;
import liquibase.util.BooleanUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Collection;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity(name = "Utilisateur")
public class UtilisateurEntity implements UserDetails {

    @Id
    @Column(name = "ID")
    private long id;


    @Column(name = "NOM", nullable = false)
    private String nom;

    @Column(name = "MAIL", nullable = false)
    private String mail;

    @Column(name = "PASSWORD", nullable = false)
    private String password;

    @Column(name = "ISENABLED", nullable = false)
    private Boolean isEnabled;

    @Column(name = "ISACCOUNTLOCKED", nullable = false)
    private Boolean isAccountLocked;


    @Column(name = "STATUT", nullable = false)
    private String statut;


    public static UtilisateurEntity fromDomain(UtilisateurModel utilisateurModel) {
        return UtilisateurEntity.builder()
                .id(utilisateurModel.getId())
                .password(utilisateurModel.getPassword())
                .isEnabled(utilisateurModel.getIsEnabled())
                .isAccountLocked(utilisateurModel.getIsAccountLocked())
                .statut(utilisateurModel.getStatut())
                .mail(utilisateurModel.getMail())
                .nom(utilisateurModel.getNom())
                .build();
    }

    public UtilisateurModel toDomain() {
        return UtilisateurModel.builder()
                .id(getId())
                .password(getPassword())
                .isEnabled(getIsEnabled())
                .isAccountLocked(getIsAccountLocked())
                .statut(getStatut())
                .mail(getMail())
                .nom(getNom())
                .build();

    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return nom;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return !BooleanUtils.isTrue(isAccountLocked);
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
