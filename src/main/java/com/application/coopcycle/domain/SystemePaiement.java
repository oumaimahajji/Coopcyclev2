package com.application.coopcycle.domain;

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
 * A SystemePaiement.
 */
@Entity
@Table(name = "systeme_paiement")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class SystemePaiement implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 16, max = 16)
    @Column(name = "credit_card", length = 16)
    private String creditCard;

    @NotNull
    @Column(name = "experation_date", nullable = false)
    private Instant experationDate;

    @Size(max = 20)
    @Column(name = "type_card", length = 20)
    private String typeCard;

    @Column(name = "amount")
    private String amount;

    @NotNull
    @Column(name = "bill_date", nullable = false)
    private Instant billDate;

    @OneToMany(mappedBy = "paidBy")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "madeBy", "paidBy" }, allowSetters = true)
    private Set<Panier> paniers = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public SystemePaiement id(Long id) {
        this.id = id;
        return this;
    }

    public String getCreditCard() {
        return this.creditCard;
    }

    public SystemePaiement creditCard(String creditCard) {
        this.creditCard = creditCard;
        return this;
    }

    public void setCreditCard(String creditCard) {
        this.creditCard = creditCard;
    }

    public Instant getExperationDate() {
        return this.experationDate;
    }

    public SystemePaiement experationDate(Instant experationDate) {
        this.experationDate = experationDate;
        return this;
    }

    public void setExperationDate(Instant experationDate) {
        this.experationDate = experationDate;
    }

    public String getTypeCard() {
        return this.typeCard;
    }

    public SystemePaiement typeCard(String typeCard) {
        this.typeCard = typeCard;
        return this;
    }

    public void setTypeCard(String typeCard) {
        this.typeCard = typeCard;
    }

    public String getAmount() {
        return this.amount;
    }

    public SystemePaiement amount(String amount) {
        this.amount = amount;
        return this;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Instant getBillDate() {
        return this.billDate;
    }

    public SystemePaiement billDate(Instant billDate) {
        this.billDate = billDate;
        return this;
    }

    public void setBillDate(Instant billDate) {
        this.billDate = billDate;
    }

    public Set<Panier> getPaniers() {
        return this.paniers;
    }

    public SystemePaiement paniers(Set<Panier> paniers) {
        this.setPaniers(paniers);
        return this;
    }

    public SystemePaiement addPanier(Panier panier) {
        this.paniers.add(panier);
        panier.setPaidBy(this);
        return this;
    }

    public SystemePaiement removePanier(Panier panier) {
        this.paniers.remove(panier);
        panier.setPaidBy(null);
        return this;
    }

    public void setPaniers(Set<Panier> paniers) {
        if (this.paniers != null) {
            this.paniers.forEach(i -> i.setPaidBy(null));
        }
        if (paniers != null) {
            paniers.forEach(i -> i.setPaidBy(this));
        }
        this.paniers = paniers;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof SystemePaiement)) {
            return false;
        }
        return id != null && id.equals(((SystemePaiement) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemePaiement{" +
            "id=" + getId() +
            ", creditCard='" + getCreditCard() + "'" +
            ", experationDate='" + getExperationDate() + "'" +
            ", typeCard='" + getTypeCard() + "'" +
            ", amount='" + getAmount() + "'" +
            ", billDate='" + getBillDate() + "'" +
            "}";
    }
}
