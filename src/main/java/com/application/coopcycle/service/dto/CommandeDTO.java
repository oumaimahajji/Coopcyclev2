package com.application.coopcycle.service.dto;

import com.application.coopcycle.domain.enumeration.EtatCommande;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Commande} entity.
 */
public class CommandeDTO implements Serializable {

    private Long id;

    @NotNull
    private Instant created;

    private EtatCommande state;

    private Instant timeStarted;

    private Instant timeEnded;

    private PanierDTO price;

    private Set<ProduitDTO> produits = new HashSet<>();

    private CompteDTO deliveredBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getCreated() {
        return created;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public EtatCommande getState() {
        return state;
    }

    public void setState(EtatCommande state) {
        this.state = state;
    }

    public Instant getTimeStarted() {
        return timeStarted;
    }

    public void setTimeStarted(Instant timeStarted) {
        this.timeStarted = timeStarted;
    }

    public Instant getTimeEnded() {
        return timeEnded;
    }

    public void setTimeEnded(Instant timeEnded) {
        this.timeEnded = timeEnded;
    }

    public PanierDTO getPrice() {
        return price;
    }

    public void setPrice(PanierDTO price) {
        this.price = price;
    }

    public Set<ProduitDTO> getProduits() {
        return produits;
    }

    public void setProduits(Set<ProduitDTO> produits) {
        this.produits = produits;
    }

    public CompteDTO getDeliveredBy() {
        return deliveredBy;
    }

    public void setDeliveredBy(CompteDTO deliveredBy) {
        this.deliveredBy = deliveredBy;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CommandeDTO)) {
            return false;
        }

        CommandeDTO commandeDTO = (CommandeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, commandeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommandeDTO{" +
            "id=" + getId() +
            ", created='" + getCreated() + "'" +
            ", state='" + getState() + "'" +
            ", timeStarted='" + getTimeStarted() + "'" +
            ", timeEnded='" + getTimeEnded() + "'" +
            ", price=" + getPrice() +
            ", produits=" + getProduits() +
            ", deliveredBy=" + getDeliveredBy() +
            "}";
    }
}
