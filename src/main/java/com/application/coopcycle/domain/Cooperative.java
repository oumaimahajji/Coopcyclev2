package com.application.coopcycle.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;
import javax.validation.constraints.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

/**
 * A Cooperative.
 */
@Entity
@Table(name = "cooperative")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Cooperative implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    @Column(name = "cooperative_name", length = 30)
    private String cooperativeName;

    @Column(name = "cooperative_city")
    private String cooperativeCity;

    @Column(name = "cooperative_address")
    private String cooperativeAddress;

    @OneToMany(mappedBy = "memberOf")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "paniers", "commandes", "memberOf" }, allowSetters = true)
    private Set<Compte> comptes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cooperative id(Long id) {
        this.id = id;
        return this;
    }

    public String getCooperativeName() {
        return this.cooperativeName;
    }

    public Cooperative cooperativeName(String cooperativeName) {
        this.cooperativeName = cooperativeName;
        return this;
    }

    public void setCooperativeName(String cooperativeName) {
        this.cooperativeName = cooperativeName;
    }

    public String getCooperativeCity() {
        return this.cooperativeCity;
    }

    public Cooperative cooperativeCity(String cooperativeCity) {
        this.cooperativeCity = cooperativeCity;
        return this;
    }

    public void setCooperativeCity(String cooperativeCity) {
        this.cooperativeCity = cooperativeCity;
    }

    public String getCooperativeAddress() {
        return this.cooperativeAddress;
    }

    public Cooperative cooperativeAddress(String cooperativeAddress) {
        this.cooperativeAddress = cooperativeAddress;
        return this;
    }

    public void setCooperativeAddress(String cooperativeAddress) {
        this.cooperativeAddress = cooperativeAddress;
    }

    public Set<Compte> getComptes() {
        return this.comptes;
    }

    public Cooperative comptes(Set<Compte> comptes) {
        this.setComptes(comptes);
        return this;
    }

    public Cooperative addCompte(Compte compte) {
        this.comptes.add(compte);
        compte.setMemberOf(this);
        return this;
    }

    public Cooperative removeCompte(Compte compte) {
        this.comptes.remove(compte);
        compte.setMemberOf(null);
        return this;
    }

    public void setComptes(Set<Compte> comptes) {
        if (this.comptes != null) {
            this.comptes.forEach(i -> i.setMemberOf(null));
        }
        if (comptes != null) {
            comptes.forEach(i -> i.setMemberOf(this));
        }
        this.comptes = comptes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Cooperative)) {
            return false;
        }
        return id != null && id.equals(((Cooperative) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Cooperative{" +
            "id=" + getId() +
            ", cooperativeName='" + getCooperativeName() + "'" +
            ", cooperativeCity='" + getCooperativeCity() + "'" +
            ", cooperativeAddress='" + getCooperativeAddress() + "'" +
            "}";
    }
}
