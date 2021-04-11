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
 * A Produit.
 */
@Entity
@Table(name = "produit")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Produit implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "product_name")
    private String productName;

    @Lob
    @Column(name = "description")
    private String description;

    @NotNull
    @Column(name = "product_price", nullable = false)
    private String productPrice;

    @Lob
    @Column(name = "image")
    private byte[] image;

    @Column(name = "image_content_type")
    private String imageContentType;

    @ManyToMany
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JoinTable(
        name = "rel_produit__restaurant",
        joinColumns = @JoinColumn(name = "produit_id"),
        inverseJoinColumns = @JoinColumn(name = "restaurant_id")
    )
    @JsonIgnoreProperties(value = { "proposes" }, allowSetters = true)
    private Set<Restaurant> restaurants = new HashSet<>();

    @ManyToMany(mappedBy = "produits")
    @Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
    @JsonIgnoreProperties(value = { "price", "produits", "deliveredBy" }, allowSetters = true)
    private Set<Commande> commandes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produit id(Long id) {
        this.id = id;
        return this;
    }

    public String getProductName() {
        return this.productName;
    }

    public Produit productName(String productName) {
        this.productName = productName;
        return this;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return this.description;
    }

    public Produit description(String description) {
        this.description = description;
        return this;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductPrice() {
        return this.productPrice;
    }

    public Produit productPrice(String productPrice) {
        this.productPrice = productPrice;
        return this;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public byte[] getImage() {
        return this.image;
    }

    public Produit image(byte[] image) {
        this.image = image;
        return this;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return this.imageContentType;
    }

    public Produit imageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
        return this;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Set<Restaurant> getRestaurants() {
        return this.restaurants;
    }

    public Produit restaurants(Set<Restaurant> restaurants) {
        this.setRestaurants(restaurants);
        return this;
    }

    public Produit addRestaurant(Restaurant restaurant) {
        this.restaurants.add(restaurant);
        restaurant.getProposes().add(this);
        return this;
    }

    public Produit removeRestaurant(Restaurant restaurant) {
        this.restaurants.remove(restaurant);
        restaurant.getProposes().remove(this);
        return this;
    }

    public void setRestaurants(Set<Restaurant> restaurants) {
        this.restaurants = restaurants;
    }

    public Set<Commande> getCommandes() {
        return this.commandes;
    }

    public Produit commandes(Set<Commande> commandes) {
        this.setCommandes(commandes);
        return this;
    }

    public Produit addCommande(Commande commande) {
        this.commandes.add(commande);
        commande.getProduits().add(this);
        return this;
    }

    public Produit removeCommande(Commande commande) {
        this.commandes.remove(commande);
        commande.getProduits().remove(this);
        return this;
    }

    public void setCommandes(Set<Commande> commandes) {
        if (this.commandes != null) {
            this.commandes.forEach(i -> i.removeProduit(this));
        }
        if (commandes != null) {
            commandes.forEach(i -> i.addProduit(this));
        }
        this.commandes = commandes;
    }

    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Produit)) {
            return false;
        }
        return id != null && id.equals(((Produit) o).id);
    }

    @Override
    public int hashCode() {
        // see https://vladmihalcea.com/how-to-implement-equals-and-hashcode-using-the-jpa-entity-identifier/
        return getClass().hashCode();
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Produit{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", description='" + getDescription() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", imageContentType='" + getImageContentType() + "'" +
            "}";
    }
}
