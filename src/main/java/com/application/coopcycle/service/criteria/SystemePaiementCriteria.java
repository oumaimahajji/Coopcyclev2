package com.application.coopcycle.service.criteria;

import java.io.Serializable;
import java.util.Objects;
import tech.jhipster.service.Criteria;
import tech.jhipster.service.filter.BooleanFilter;
import tech.jhipster.service.filter.DoubleFilter;
import tech.jhipster.service.filter.Filter;
import tech.jhipster.service.filter.FloatFilter;
import tech.jhipster.service.filter.InstantFilter;
import tech.jhipster.service.filter.IntegerFilter;
import tech.jhipster.service.filter.LongFilter;
import tech.jhipster.service.filter.StringFilter;

/**
 * Criteria class for the {@link com.application.coopcycle.domain.SystemePaiement} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.SystemePaiementResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /systeme-paiements?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class SystemePaiementCriteria implements Serializable, Criteria {

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter creditCard;

    private InstantFilter experationDate;

    private StringFilter typeCard;

    private StringFilter amount;

    private InstantFilter billDate;

    private LongFilter panierId;

    public SystemePaiementCriteria() {}

    public SystemePaiementCriteria(SystemePaiementCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.creditCard = other.creditCard == null ? null : other.creditCard.copy();
        this.experationDate = other.experationDate == null ? null : other.experationDate.copy();
        this.typeCard = other.typeCard == null ? null : other.typeCard.copy();
        this.amount = other.amount == null ? null : other.amount.copy();
        this.billDate = other.billDate == null ? null : other.billDate.copy();
        this.panierId = other.panierId == null ? null : other.panierId.copy();
    }

    @Override
    public SystemePaiementCriteria copy() {
        return new SystemePaiementCriteria(this);
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

    public StringFilter getCreditCard() {
        return creditCard;
    }

    public StringFilter creditCard() {
        if (creditCard == null) {
            creditCard = new StringFilter();
        }
        return creditCard;
    }

    public void setCreditCard(StringFilter creditCard) {
        this.creditCard = creditCard;
    }

    public InstantFilter getExperationDate() {
        return experationDate;
    }

    public InstantFilter experationDate() {
        if (experationDate == null) {
            experationDate = new InstantFilter();
        }
        return experationDate;
    }

    public void setExperationDate(InstantFilter experationDate) {
        this.experationDate = experationDate;
    }

    public StringFilter getTypeCard() {
        return typeCard;
    }

    public StringFilter typeCard() {
        if (typeCard == null) {
            typeCard = new StringFilter();
        }
        return typeCard;
    }

    public void setTypeCard(StringFilter typeCard) {
        this.typeCard = typeCard;
    }

    public StringFilter getAmount() {
        return amount;
    }

    public StringFilter amount() {
        if (amount == null) {
            amount = new StringFilter();
        }
        return amount;
    }

    public void setAmount(StringFilter amount) {
        this.amount = amount;
    }

    public InstantFilter getBillDate() {
        return billDate;
    }

    public InstantFilter billDate() {
        if (billDate == null) {
            billDate = new InstantFilter();
        }
        return billDate;
    }

    public void setBillDate(InstantFilter billDate) {
        this.billDate = billDate;
    }

    public LongFilter getPanierId() {
        return panierId;
    }

    public LongFilter panierId() {
        if (panierId == null) {
            panierId = new LongFilter();
        }
        return panierId;
    }

    public void setPanierId(LongFilter panierId) {
        this.panierId = panierId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final SystemePaiementCriteria that = (SystemePaiementCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(creditCard, that.creditCard) &&
            Objects.equals(experationDate, that.experationDate) &&
            Objects.equals(typeCard, that.typeCard) &&
            Objects.equals(amount, that.amount) &&
            Objects.equals(billDate, that.billDate) &&
            Objects.equals(panierId, that.panierId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creditCard, experationDate, typeCard, amount, billDate, panierId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "SystemePaiementCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (creditCard != null ? "creditCard=" + creditCard + ", " : "") +
            (experationDate != null ? "experationDate=" + experationDate + ", " : "") +
            (typeCard != null ? "typeCard=" + typeCard + ", " : "") +
            (amount != null ? "amount=" + amount + ", " : "") +
            (billDate != null ? "billDate=" + billDate + ", " : "") +
            (panierId != null ? "panierId=" + panierId + ", " : "") +
            "}";
    }
}
