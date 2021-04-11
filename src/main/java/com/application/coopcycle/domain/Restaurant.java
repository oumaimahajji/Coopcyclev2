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
 * A Restaurant.
 */
@Entity
@Table(name = "restaurant")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Restaurant implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(max = 30)
    @Column(name = "restaurant_name", length = 30)
    private String restaurantName;

    @Column(name = "delivery_price")
    private String deliveryPrice;

    @Column(name = "restaurant_address")
    private String restaurantAddress;

    @Size(max = 30)
    @Column(name = "restaurant_city", length = 30)
    private String restaurantCity;

    @ManyToMany(mappedBy = "restaurants")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "restaurants", "commandes" }, allowSetters = true)
    private Set<Produit> proposes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Restaurant id(Long id) {
        this.id = id;
        return this;
    }

    public String getRestaurantName() {
        return this.restaurantName;
    }

    public Restaurant restaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
        return this;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDeliveryPrice() {
        return this.deliveryPrice;
    }

    public Restaurant deliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
        return this;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getRestaurantAddress() {
        return this.restaurantAddress;
    }

    public Restaurant restaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
        return this;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantCity() {
        return this.restaurantCity;
    }

    public Restaurant restaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
        return this;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    public Set<Produit> getProposes() {
        return this.proposes;
    }

    public Restaurant proposes(Set<Produit> produits) {
        this.setProposes(produits);
        return this;
    }

    public Restaurant addProposes(Produit produit) {
        this.proposes.add(produit);
        produit.getRestaurants().add(this);
        return this;
    }

    public Restaurant removeProposes(Produit produit) {
        this.proposes.remove(produit);
        produit.getRestaurants().remove(this);
        return this;
    }

    public void setProposes(Set<Produit> produits) {
        if (this.proposes != null) {
            this.proposes.forEach(i -> i.removeRestaurant(this));
        }
        if (produits != null) {
            produits.forEach(i -> i.addRestaurant(this));
        }
        this.proposes = produits;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Restaurant)) {
            return false;
        }
        return id != null && id.equals(((Restaurant) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Restaurant{" +
            "id=" + getId() +
            ", restaurantName='" + getRestaurantName() + "'" +
            ", deliveryPrice='" + getDeliveryPrice() + "'" +
            ", restaurantAddress='" + getRestaurantAddress() + "'" +
            ", restaurantCity='" + getRestaurantCity() + "'" +
            "}";
    }
}
