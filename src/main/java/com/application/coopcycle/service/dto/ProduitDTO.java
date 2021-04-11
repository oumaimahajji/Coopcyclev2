package com.application.coopcycle.service.dto;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Lob;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Produit} entity.
 */
public class ProduitDTO implements Serializable {

    private Long id;

    private String productName;

    @Lob
    private String description;

    @NotNull
    private String productPrice;

    @Lob
    private byte[] image;

    private String imageContentType;
    private Set<RestaurantDTO> restaurants = new HashSet<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }

    public byte[] getImage() {
        return image;
    }

    public void setImage(byte[] image) {
        this.image = image;
    }

    public String getImageContentType() {
        return imageContentType;
    }

    public void setImageContentType(String imageContentType) {
        this.imageContentType = imageContentType;
    }

    public Set<RestaurantDTO> getRestaurants() {
        return restaurants;
    }

    public void setRestaurants(Set<RestaurantDTO> restaurants) {
        this.restaurants = restaurants;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof ProduitDTO)) {
            return false;
        }

        ProduitDTO produitDTO = (ProduitDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, produitDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProduitDTO{" +
            "id=" + getId() +
            ", productName='" + getProductName() + "'" +
            ", description='" + getDescription() + "'" +
            ", productPrice='" + getProductPrice() + "'" +
            ", image='" + getImage() + "'" +
            ", restaurants=" + getRestaurants() +
            "}";
    }
}
