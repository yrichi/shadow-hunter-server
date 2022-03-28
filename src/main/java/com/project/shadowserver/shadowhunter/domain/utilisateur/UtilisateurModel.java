package com.project.shadowserver.shadowhunter.domain.utilisateur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UtilisateurModel {

    private long id;

    private String nom;

    private String mail;

    private String password;

    private Boolean isEnabled;

    private Boolean isAccountLocked;


    private String statut;
}
