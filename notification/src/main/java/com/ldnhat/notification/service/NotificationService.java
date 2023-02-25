package com.ldnhat.notification.service;

import com.ldnhat.clients.notification.NotificationDTO;

public interface NotificationService {
    /**
     * Save a notification.
     *
     * @param notificationDTO
     * @return the persisted entity.
     */
    NotificationDTO save(NotificationDTO notificationDTO);
}
