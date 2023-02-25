package com.ldnhat.notification.web.rest;

import com.ldnhat.clients.notification.NotificationDTO;
import com.ldnhat.notification.service.NotificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/v1/notification")
public class NotificationResource {
    private final NotificationService notificationService;

    public NotificationResource(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    /**
     * {@code POST} : save notification.
     *
     * @param notificationDTO {@link NotificationDTO}
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @PostMapping
    public ResponseEntity<Void> fraud(@RequestBody NotificationDTO notificationDTO) {
        log.info("REST request to save notification {}", notificationDTO);
        notificationService.save(notificationDTO);
        return ResponseEntity.noContent().build();
    }
}
