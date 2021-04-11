package com.application.coopcycle.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Panier} entity.
 */
public class PanierDTO implements Serializable {

    private Long id;

    private String price;

    private CompteDTO madeBy;

    private SystemePaiementDTO paidBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public CompteDTO getMadeBy() {
        return madeBy;
    }

    public void setMadeBy(CompteDTO madeBy) {
        this.madeBy = madeBy;
    }

    public SystemePaiementDTO getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(SystemePaiementDTO paidBy) {
        this.paidBy = paidBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof PanierDTO)) {
            return false;
        }

        PanierDTO panierDTO = (PanierDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, panierDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PanierDTO{" +
            "id=" + getId() +
            ", price='" + getPrice() + "'" +
            ", madeBy=" + getMadeBy() +
            ", paidBy=" + getPaidBy() +
            "}";
    }
}
