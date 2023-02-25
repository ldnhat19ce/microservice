package com.ldnhat.clients.notification;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class NotificationDTO {
    private Integer id;
    private Integer toCustomerId;
    private String toCustomerEmail;
    private String sender;
    private String message;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof NotificationDTO)) {
            return false;
        }
        return id != null && id.equals(((NotificationDTO) o).id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
