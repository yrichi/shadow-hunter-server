package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Notification {
    Boolean isPublic;
    String idJoueur;
    String message;
    TypeNotificationEnum typeNotificationEnum;

}
