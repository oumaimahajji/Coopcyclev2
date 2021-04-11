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
 * Criteria class for the {@link com.application.coopcycle.domain.Panier} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.PanierResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /paniers?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class PanierCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter price;

    private LongFilter madeById;

    private LongFilter paidById;

    public PanierCriteria() {}

    public PanierCriteria(PanierCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.price = other.price == null ? null : other.price.copy();
        this.madeById = other.madeById == null ? null : other.madeById.copy();
        this.paidById = other.paidById == null ? null : other.paidById.copy();
    }

    @Override
    public PanierCriteria copy() {
        return new PanierCriteria(this);
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

    public StringFilter getPrice() {
        return price;
    }

    public StringFilter price() {
        if (price == null) {
            price = new StringFilter();
        }
        return price;
    }

    public void setPrice(StringFilter price) {
        this.price = price;
    }

    public LongFilter getMadeById() {
        return madeById;
    }

    public LongFilter madeById() {
        if (madeById == null) {
            madeById = new LongFilter();
        }
        return madeById;
    }

    public void setMadeById(LongFilter madeById) {
        this.madeById = madeById;
    }

    public LongFilter getPaidById() {
        return paidById;
    }

    public LongFilter paidById() {
        if (paidById == null) {
            paidById = new LongFilter();
        }
        return paidById;
    }

    public void setPaidById(LongFilter paidById) {
        this.paidById = paidById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PanierCriteria that = (PanierCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(price, that.price) &&
            Objects.equals(madeById, that.madeById) &&
            Objects.equals(paidById, that.paidById)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, price, madeById, paidById);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "PanierCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (price != null ? "price=" + price + ", " : "") +
            (madeById != null ? "madeById=" + madeById + ", " : "") +
            (paidById != null ? "paidById=" + paidById + ", " : "") +
            "}";
    }
}
