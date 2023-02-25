package com.ldnhat.clients.fraud;

import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FraudCheckDTO {
    private Integer id;
    private Integer customerId;
    private Boolean isFraudster;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (this.id == null) return false;
        if (!(o instanceof FraudCheckDTO)) {
            return false;
        }
        FraudCheckDTO that = (FraudCheckDTO) o;
        return Objects.equals(this.id, that.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }

    @Override
    public String toString() {
        return "FraudCheckDTO{" +
                "id=" + id +
                ", customerId=" + customerId +
                ", isFraudster=" + isFraudster +
                '}';
    }
}
