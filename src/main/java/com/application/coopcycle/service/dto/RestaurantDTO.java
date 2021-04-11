package com.application.coopcycle.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Restaurant} entity.
 */
public class RestaurantDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String restaurantName;

    private String deliveryPrice;

    private String restaurantAddress;

    @Size(max = 30)
    private String restaurantCity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRestaurantName() {
        return restaurantName;
    }

    public void setRestaurantName(String restaurantName) {
        this.restaurantName = restaurantName;
    }

    public String getDeliveryPrice() {
        return deliveryPrice;
    }

    public void setDeliveryPrice(String deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String getRestaurantAddress() {
        return restaurantAddress;
    }

    public void setRestaurantAddress(String restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public String getRestaurantCity() {
        return restaurantCity;
    }

    public void setRestaurantCity(String restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof RestaurantDTO)) {
            return false;
        }

        RestaurantDTO restaurantDTO = (RestaurantDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, restaurantDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RestaurantDTO{" +
            "id=" + getId() +
            ", restaurantName='" + getRestaurantName() + "'" +
            ", deliveryPrice='" + getDeliveryPrice() + "'" +
            ", restaurantAddress='" + getRestaurantAddress() + "'" +
            ", restaurantCity='" + getRestaurantCity() + "'" +
            "}";
    }
}
