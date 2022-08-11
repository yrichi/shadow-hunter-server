package com.project.shadowserver.shadowhunter.domain.gestionjeu.model.carte;

import lombok.Builder;
import lombok.Data;

/**
 *
 */
@Data
@Builder
public class NotificationFactory {

    public static Notification buildNotification(TypeNotificationEnum typeNotificationEnum, String idJoueurEmeteur, String message) {
        return Notification.builder()
                .typeNotificationEnum(typeNotificationEnum)
                .idJoueur(idJoueurEmeteur)
                .message(message)
                .build();
    }

}
