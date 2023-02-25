package com.ldnhat.notification.rabbitmq;

import com.ldnhat.clients.notification.NotificationDTO;
import com.ldnhat.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class NotificationConsumer {
    private final NotificationService notificationService;

    @RabbitListener(queues = "${rabbitmq.queues.notification}")
    public void consumer(NotificationDTO notificationDTO) {
        log.info("Consumed {} from queue", notificationDTO);
        notificationService.save(notificationDTO);
    }
}
