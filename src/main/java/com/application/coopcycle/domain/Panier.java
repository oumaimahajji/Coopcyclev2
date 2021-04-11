package com.application.coopcycle.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Panier.
 */
@Entity
@Table(name = "panier")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Panier implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "price")
    private String price;

    @ManyToOne
    @JsonIgnoreProperties(value = { "paniers", "commandes", "memberOf" }, allowSetters = true)
    private Compte madeBy;

    @ManyToOne
    @JsonIgnoreProperties(value = { "paniers" }, allowSetters = true)
    private SystemePaiement paidBy;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Panier id(Long id) {
        this.id = id;
        return this;
    }

    public String getPrice() {
        return this.price;
    }

    public Panier price(String price) {
        this.price = price;
        return this;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Compte getMadeBy() {
        return this.madeBy;
    }

    public Panier madeBy(Compte compte) {
        this.setMadeBy(compte);
        return this;
    }

    public void setMadeBy(Compte compte) {
        this.madeBy = compte;
    }

    public SystemePaiement getPaidBy() {
        return this.paidBy;
    }

    public Panier paidBy(SystemePaiement systemePaiement) {
        this.setPaidBy(systemePaiement);
        return this;
    }

    public void setPaidBy(SystemePaiement systemePaiement) {
        this.paidBy = systemePaiement;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Panier)) {
            return false;
        }
        return id != null && id.equals(((Panier) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Panier{" +
            "id=" + getId() +
            ", price='" + getPrice() + "'" +
            "}";
    }
}
