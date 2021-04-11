package com.application.coopcycle.domain;

import com.application.coopcycle.domain.enumeration.EtatCommande;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Commande.
 */
@Entity
@Table(name = "commande")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Commande implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "created", nullable = false)
    private Instant created;

    @Enumerated(EnumType.STRING)
    @Column(name = "state")
    private EtatCommande state;

    @Column(name = "time_started")
    private Instant timeStarted;

    @Column(name = "time_ended")
    private Instant timeEnded;

    @JsonIgnoreProperties(value = { "madeBy", "paidBy" }, allowSetters = true)
    @OneToOne
    @JoinColumn(unique = true)
    private Panier price;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_commande__produit",
        joinColumns = @JoinColumn(name = "commande_id"),
        inverseJoinColumns = @JoinColumn(name = "produit_id")
    )
    @JsonIgnoreProperties(value = { "restaurants", "commandes" }, allowSetters = true)
    private Set<Produit> produits = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "paniers", "commandes", "memberOf" }, allowSetters = true)
    private Compte deliveredBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Commande id(Long id) {
        this.id = id;
        return this;
    }

    public Instant getCreated() {
        return this.created;
    }

    public Commande created(Instant created) {
        this.created = created;
        return this;
    }

    public void setCreated(Instant created) {
        this.created = created;
    }

    public EtatCommande getState() {
        return this.state;
    }

    public Commande state(EtatCommande state) {
        this.state = state;
        return this;
    }

    public void setState(EtatCommande state) {
        this.state = state;
    }

    public Instant getTimeStarted() {
        return this.timeStarted;
    }

    public Commande timeStarted(Instant timeStarted) {
        this.timeStarted = timeStarted;
        return this;
    }

    public void setTimeStarted(Instant timeStarted) {
        this.timeStarted = timeStarted;
    }

    public Instant getTimeEnded() {
        return this.timeEnded;
    }

    public Commande timeEnded(Instant timeEnded) {
        this.timeEnded = timeEnded;
        return this;
    }

    public void setTimeEnded(Instant timeEnded) {
        this.timeEnded = timeEnded;
    }

    public Panier getPrice() {
        return this.price;
    }

    public Commande price(Panier panier) {
        this.setPrice(panier);
        return this;
    }

    public void setPrice(Panier panier) {
        this.price = panier;
    }

    public Set<Produit> getProduits() {
        return this.produits;
    }

    public Commande produits(Set<Produit> produits) {
        this.setProduits(produits);
        return this;
    }

    public Commande addProduit(Produit produit) {
        this.produits.add(produit);
        produit.getCommandes().add(this);
        return this;
    }

    public Commande removeProduit(Produit produit) {
        this.produits.remove(produit);
        produit.getCommandes().remove(this);
        return this;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

    public Compte getDeliveredBy() {
        return this.deliveredBy;
    }

    public Commande deliveredBy(Compte compte) {
        this.setDeliveredBy(compte);
        return this;
    }

    public void setDeliveredBy(Compte compte) {
        this.deliveredBy = compte;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Commande)) {
            return false;
        }
        return id != null && id.equals(((Commande) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Commande{" +
            "id=" + getId() +
            ", created='" + getCreated() + "'" +
            ", state='" + getState() + "'" +
            ", timeStarted='" + getTimeStarted() + "'" +
            ", timeEnded='" + getTimeEnded() + "'" +
            "}";
    }
}
