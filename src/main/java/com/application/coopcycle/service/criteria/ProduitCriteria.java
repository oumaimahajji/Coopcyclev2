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
 * Criteria class for the {@link com.application.coopcycle.domain.Produit} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.ProduitResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /produits?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class ProduitCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter productName;

    private StringFilter productPrice;

    private LongFilter restaurantId;

    private LongFilter commandeId;

    public ProduitCriteria() {}

    public ProduitCriteria(ProduitCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.productName = other.productName == null ? null : other.productName.copy();
        this.productPrice = other.productPrice == null ? null : other.productPrice.copy();
        this.restaurantId = other.restaurantId == null ? null : other.restaurantId.copy();
        this.commandeId = other.commandeId == null ? null : other.commandeId.copy();
    }

    @Override
    public ProduitCriteria copy() {
        return new ProduitCriteria(this);
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

    public StringFilter getProductName() {
        return productName;
    }

    public StringFilter productName() {
        if (productName == null) {
            productName = new StringFilter();
        }
        return productName;
    }

    public void setProductName(StringFilter productName) {
        this.productName = productName;
    }

    public StringFilter getProductPrice() {
        return productPrice;
    }

    public StringFilter productPrice() {
        if (productPrice == null) {
            productPrice = new StringFilter();
        }
        return productPrice;
    }

    public void setProductPrice(StringFilter productPrice) {
        this.productPrice = productPrice;
    }

    public LongFilter getRestaurantId() {
        return restaurantId;
    }

    public LongFilter restaurantId() {
        if (restaurantId == null) {
            restaurantId = new LongFilter();
        }
        return restaurantId;
    }

    public void setRestaurantId(LongFilter restaurantId) {
        this.restaurantId = restaurantId;
    }

    public LongFilter getCommandeId() {
        return commandeId;
    }

    public LongFilter commandeId() {
        if (commandeId == null) {
            commandeId = new LongFilter();
        }
        return commandeId;
    }

    public void setCommandeId(LongFilter commandeId) {
        this.commandeId = commandeId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final ProduitCriteria that = (ProduitCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(productName, that.productName) &&
            Objects.equals(productPrice, that.productPrice) &&
            Objects.equals(restaurantId, that.restaurantId) &&
            Objects.equals(commandeId, that.commandeId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, productName, productPrice, restaurantId, commandeId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "ProduitCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (productName != null ? "productName=" + productName + ", " : "") +
            (productPrice != null ? "productPrice=" + productPrice + ", " : "") +
            (restaurantId != null ? "restaurantId=" + restaurantId + ", " : "") +
            (commandeId != null ? "commandeId=" + commandeId + ", " : "") +
            "}";
    }
}
