package com.application.coopcycle.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.application.coopcycle.domain.Restaurant} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.RestaurantResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /restaurants?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class RestaurantCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter restaurantName;

    private StringFilter deliveryPrice;

    private StringFilter restaurantAddress;

    private StringFilter restaurantCity;

    private LongFilter proposesId;

    public RestaurantCriteria() {}

    public RestaurantCriteria(RestaurantCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.restaurantName = other.restaurantName == null ? null : other.restaurantName.copy();
        this.deliveryPrice = other.deliveryPrice == null ? null : other.deliveryPrice.copy();
        this.restaurantAddress = other.restaurantAddress == null ? null : other.restaurantAddress.copy();
        this.restaurantCity = other.restaurantCity == null ? null : other.restaurantCity.copy();
        this.proposesId = other.proposesId == null ? null : other.proposesId.copy();
    }

    @Override
    public RestaurantCriteria copy() {
        return new RestaurantCriteria(this);
    }

    public LongFilter getId() {
        return id;
    }

    public LongFilter id() {
        if (id == null) {
            id = new LongFilter();
        }
        return id;
    }

    public void setId(LongFilter id) {
        this.id = id;
    }

    public StringFilter getRestaurantName() {
        return restaurantName;
    }

    public StringFilter restaurantName() {
        if (restaurantName == null) {
            restaurantName = new StringFilter();
        }
        return restaurantName;
    }

    public void setRestaurantName(StringFilter restaurantName) {
        this.restaurantName = restaurantName;
    }

    public StringFilter getDeliveryPrice() {
        return deliveryPrice;
    }

    public StringFilter deliveryPrice() {
        if (deliveryPrice == null) {
            deliveryPrice = new StringFilter();
        }
        return deliveryPrice;
    }

    public void setDeliveryPrice(StringFilter deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public StringFilter getRestaurantAddress() {
        return restaurantAddress;
    }

    public StringFilter restaurantAddress() {
        if (restaurantAddress == null) {
            restaurantAddress = new StringFilter();
        }
        return restaurantAddress;
    }

    public void setRestaurantAddress(StringFilter restaurantAddress) {
        this.restaurantAddress = restaurantAddress;
    }

    public StringFilter getRestaurantCity() {
        return restaurantCity;
    }

    public StringFilter restaurantCity() {
        if (restaurantCity == null) {
            restaurantCity = new StringFilter();
        }
        return restaurantCity;
    }

    public void setRestaurantCity(StringFilter restaurantCity) {
        this.restaurantCity = restaurantCity;
    }

    public LongFilter getProposesId() {
        return proposesId;
    }

    public LongFilter proposesId() {
        if (proposesId == null) {
            proposesId = new LongFilter();
        }
        return proposesId;
    }

    public void setProposesId(LongFilter proposesId) {
        this.proposesId = proposesId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final RestaurantCriteria that = (RestaurantCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(restaurantName, that.restaurantName) &&
            Objects.equals(deliveryPrice, that.deliveryPrice) &&
            Objects.equals(restaurantAddress, that.restaurantAddress) &&
            Objects.equals(restaurantCity, that.restaurantCity) &&
            Objects.equals(proposesId, that.proposesId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, restaurantName, deliveryPrice, restaurantAddress, restaurantCity, proposesId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "RestaurantCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (restaurantName != null ? "restaurantName=" + restaurantName + ", " : "") +
            (deliveryPrice != null ? "deliveryPrice=" + deliveryPrice + ", " : "") +
            (restaurantAddress != null ? "restaurantAddress=" + restaurantAddress + ", " : "") +
            (restaurantCity != null ? "restaurantCity=" + restaurantCity + ", " : "") +
            (proposesId != null ? "proposesId=" + proposesId + ", " : "") +
            "}";
    }
}
