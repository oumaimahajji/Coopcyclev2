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
 * Criteria class for the {@link com.application.coopcycle.domain.Cooperative} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.CooperativeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /cooperatives?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CooperativeCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter cooperativeName;

    private StringFilter cooperativeCity;

    private StringFilter cooperativeAddress;

    private LongFilter compteId;

    public CooperativeCriteria() {}

    public CooperativeCriteria(CooperativeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.cooperativeName = other.cooperativeName == null ? null : other.cooperativeName.copy();
        this.cooperativeCity = other.cooperativeCity == null ? null : other.cooperativeCity.copy();
        this.cooperativeAddress = other.cooperativeAddress == null ? null : other.cooperativeAddress.copy();
        this.compteId = other.compteId == null ? null : other.compteId.copy();
    }

    @Override
    public CooperativeCriteria copy() {
        return new CooperativeCriteria(this);
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

    public StringFilter getCooperativeName() {
        return cooperativeName;
    }

    public StringFilter cooperativeName() {
        if (cooperativeName == null) {
            cooperativeName = new StringFilter();
        }
        return cooperativeName;
    }

    public void setCooperativeName(StringFilter cooperativeName) {
        this.cooperativeName = cooperativeName;
    }

    public StringFilter getCooperativeCity() {
        return cooperativeCity;
    }

    public StringFilter cooperativeCity() {
        if (cooperativeCity == null) {
            cooperativeCity = new StringFilter();
        }
        return cooperativeCity;
    }

    public void setCooperativeCity(StringFilter cooperativeCity) {
        this.cooperativeCity = cooperativeCity;
    }

    public StringFilter getCooperativeAddress() {
        return cooperativeAddress;
    }

    public StringFilter cooperativeAddress() {
        if (cooperativeAddress == null) {
            cooperativeAddress = new StringFilter();
        }
        return cooperativeAddress;
    }

    public void setCooperativeAddress(StringFilter cooperativeAddress) {
        this.cooperativeAddress = cooperativeAddress;
    }

    public LongFilter getCompteId() {
        return compteId;
    }

    public LongFilter compteId() {
        if (compteId == null) {
            compteId = new LongFilter();
        }
        return compteId;
    }

    public void setCompteId(LongFilter compteId) {
        this.compteId = compteId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CooperativeCriteria that = (CooperativeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(cooperativeName, that.cooperativeName) &&
            Objects.equals(cooperativeCity, that.cooperativeCity) &&
            Objects.equals(cooperativeAddress, that.cooperativeAddress) &&
            Objects.equals(compteId, that.compteId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cooperativeName, cooperativeCity, cooperativeAddress, compteId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CooperativeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (cooperativeName != null ? "cooperativeName=" + cooperativeName + ", " : "") +
            (cooperativeCity != null ? "cooperativeCity=" + cooperativeCity + ", " : "") +
            (cooperativeAddress != null ? "cooperativeAddress=" + cooperativeAddress + ", " : "") +
            (compteId != null ? "compteId=" + compteId + ", " : "") +
            "}";
    }
}
