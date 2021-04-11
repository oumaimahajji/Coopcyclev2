package com.application.coopcycle.domain;

import com.application.coopcycle.domain.enumeration.Role;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Compte.
 */
@Entity
@Table(name = "compte")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Compte implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column(name = "name", nullable = false)
    private String name;

    @NotNull
    @Column(name = "surname", nullable = false)
    private String surname;

    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@(|gmail|imag|hotmail|yahoo+)\\.(fr|com)$")
    @Column(name = "email", nullable = false)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "categorie")
    private Role categorie;

    @Size(min = 10, max = 10)
    @Column(name = "phone_number", length = 10)
    private String phoneNumber;

    @Size(max = 100)
    @Column(name = "address", length = 100)
    private String address;

    @Size(min = 5, max = 5)
    @Column(name = "postal_code", length = 5)
    private String postalCode;

    @Size(max = 30)
    @Column(name = "city", length = 30)
    private String city;

    @OneToMany(mappedBy = "madeBy")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "madeBy", "paidBy" }, allowSetters = true)
    private Set<Panier> paniers = new HashSet<>();

    @OneToMany(mappedBy = "deliveredBy")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "price", "produits", "deliveredBy" }, allowSetters = true)
    private Set<Commande> commandes = new HashSet<>();

    @ManyToOne
    @JsonIgnoreProperties(value = { "comptes" }, allowSetters = true)
    private Cooperative memberOf;

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Compte id(Long id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return this.name;
    }

    public Compte name(String name) {
        this.name = name;
        return this;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return this.surname;
    }

    public Compte surname(String surname) {
        this.surname = surname;
        return this;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return this.email;
    }

    public Compte email(String email) {
        this.email = email;
        return this;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getCategorie() {
        return this.categorie;
    }

    public Compte categorie(Role categorie) {
        this.categorie = categorie;
        return this;
    }

    public void setCategorie(Role categorie) {
        this.categorie = categorie;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public Compte phoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return this.address;
    }

    public Compte address(String address) {
        this.address = address;
        return this;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return this.postalCode;
    }

    public Compte postalCode(String postalCode) {
        this.postalCode = postalCode;
        return this;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return this.city;
    }

    public Compte city(String city) {
        this.city = city;
        return this;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Set<Panier> getPaniers() {
        return this.paniers;
    }

    public Compte paniers(Set<Panier> paniers) {
        this.setPaniers(paniers);
        return this;
    }

    public Compte addPanier(Panier panier) {
        this.paniers.add(panier);
        panier.setMadeBy(this);
        return this;
    }

    public Compte removePanier(Panier panier) {
        this.paniers.remove(panier);
        panier.setMadeBy(null);
        return this;
    }

    public void setPaniers(Set<Panier> paniers) {
        if (this.paniers != null) {
            this.paniers.forEach(i -> i.setMadeBy(null));
        }
        if (paniers != null) {
            paniers.forEach(i -> i.setMadeBy(this));
        }
        this.paniers = paniers;
    }

    public Set<Commande> getCommandes() {
        return this.commandes;
    }

    public Compte commandes(Set<Commande> commandes) {
        this.setCommandes(commandes);
        return this;
    }

    public Compte addCommande(Commande commande) {
        this.commandes.add(commande);
        commande.setDeliveredBy(this);
        return this;
    }

    public Compte removeCommande(Commande commande) {
        this.commandes.remove(commande);
        commande.setDeliveredBy(null);
        return this;
    }

    public void setCommandes(Set<Commande> commandes) {
        if (this.commandes != null) {
            this.commandes.forEach(i -> i.setDeliveredBy(null));
        }
        if (commandes != null) {
            commandes.forEach(i -> i.setDeliveredBy(this));
        }
        this.commandes = commandes;
    }

    public Cooperative getMemberOf() {
        return this.memberOf;
    }

    public Compte memberOf(Cooperative cooperative) {
        this.setMemberOf(cooperative);
        return this;
    }

    public void setMemberOf(Cooperative cooperative) {
        this.memberOf = cooperative;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Compte)) {
            return false;
        }
        return id != null && id.equals(((Compte) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Compte{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", email='" + getEmail() + "'" +
            ", categorie='" + getCategorie() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", city='" + getCity() + "'" +
            "}";
    }
}
