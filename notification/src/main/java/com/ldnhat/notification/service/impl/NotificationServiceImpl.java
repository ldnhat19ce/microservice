package com.ldnhat.notification.service.impl;

import com.ldnhat.clients.notification.NotificationDTO;
import com.ldnhat.notification.domain.Notification;
import com.ldnhat.notification.repository.NotificationRepository;
import com.ldnhat.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public NotificationDTO save(NotificationDTO notificationDTO) {
        Notification result = notificationRepository.save(
                Notification.builder()
                        .toCustomerId(notificationDTO.getToCustomerId())
                        .toCustomerEmail(notificationDTO.getToCustomerEmail())
                        .sender("admin")
                        .message(notificationDTO.getMessage())
                        .build());
        return NotificationDTO.builder()
                .id(result.getId())
                .toCustomerId(result.getToCustomerId())
                .toCustomerEmail(result.getToCustomerEmail())
                .message(result.getMessage())
                .sender(result.getSender())
                .build();
    }
}
