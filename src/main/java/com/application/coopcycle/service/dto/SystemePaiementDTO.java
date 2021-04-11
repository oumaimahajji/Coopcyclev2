package com.application.coopcycle.service.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.SystemePaiement} entity.
 */
public class SystemePaiementDTO implements Serializable {

    private Long id;

    @Size(min = 16, max = 16)
    private String creditCard;

    @NotNull
    private Instant experationDate;

    @Size(max = 20)
    private String typeCard;

    private String amount;

    @NotNull
    private Instant billDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCreditCard() {
        return creditCard;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Instant getExperationDate() {
        return experationDate;
    }

    public void setExperationDate(Instant experationDate) {
        this.experationDate = experationDate;
    }

    public String getTypeCard() {
        return typeCard;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Instant getBillDate() {
        return billDate;
    }

    public void setBillDate(Instant billDate) {
        this.billDate = billDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemePaiementDTO)) {
            return false;
        }

        SystemePaiementDTO systemePaiementDTO = (SystemePaiementDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, systemePaiementDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemePaiementDTO{" +
            "id=" + getId() +
            ", creditCard='" + getCreditCard() + "'" +
            ", experationDate='" + getExperationDate() + "'" +
            ", typeCard='" + getTypeCard() + "'" +
            ", amount='" + getAmount() + "'" +
            ", billDate='" + getBillDate() + "'" +
            "}";
    }
}
