package com.application.coopcycle.service.criteria;

import com.application.coopcycle.domain.enumeration.EtatCommande;
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
 * Criteria class for the {@link com.application.coopcycle.domain.Commande} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.CommandeResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /commandes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CommandeCriteria implements Serializable, Criteria {

    /**
     * Class for filtering EtatCommande
     */
    public static class EtatCommandeFilter extends Filter<EtatCommande> {

        public EtatCommandeFilter() {}

        public EtatCommandeFilter(EtatCommandeFilter filter) {
            super(filter);
        }

        @Override
        public EtatCommandeFilter copy() {
            return new EtatCommandeFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private InstantFilter created;

    private EtatCommandeFilter state;

    private InstantFilter timeStarted;

    private InstantFilter timeEnded;

    private LongFilter priceId;

    private LongFilter produitId;

    private LongFilter deliveredById;

    public CommandeCriteria() {}

    public CommandeCriteria(CommandeCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.created = other.created == null ? null : other.created.copy();
        this.state = other.state == null ? null : other.state.copy();
        this.timeStarted = other.timeStarted == null ? null : other.timeStarted.copy();
        this.timeEnded = other.timeEnded == null ? null : other.timeEnded.copy();
        this.priceId = other.priceId == null ? null : other.priceId.copy();
        this.produitId = other.produitId == null ? null : other.produitId.copy();
        this.deliveredById = other.deliveredById == null ? null : other.deliveredById.copy();
    }

    @Override
    public CommandeCriteria copy() {
        return new CommandeCriteria(this);
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

    public InstantFilter getCreated() {
        return created;
    }

    public InstantFilter created() {
        if (created == null) {
            created = new InstantFilter();
        }
        return created;
    }

    public void setCreated(InstantFilter created) {
        this.created = created;
    }

    public EtatCommandeFilter getState() {
        return state;
    }

    public EtatCommandeFilter state() {
        if (state == null) {
            state = new EtatCommandeFilter();
        }
        return state;
    }

    public void setState(EtatCommandeFilter state) {
        this.state = state;
    }

    public InstantFilter getTimeStarted() {
        return timeStarted;
    }

    public InstantFilter timeStarted() {
        if (timeStarted == null) {
            timeStarted = new InstantFilter();
        }
        return timeStarted;
    }

    public void setTimeStarted(InstantFilter timeStarted) {
        this.timeStarted = timeStarted;
    }

    public InstantFilter getTimeEnded() {
        return timeEnded;
    }

    public InstantFilter timeEnded() {
        if (timeEnded == null) {
            timeEnded = new InstantFilter();
        }
        return timeEnded;
    }

    public void setTimeEnded(InstantFilter timeEnded) {
        this.timeEnded = timeEnded;
    }

    public LongFilter getPriceId() {
        return priceId;
    }

    public LongFilter priceId() {
        if (priceId == null) {
            priceId = new LongFilter();
        }
        return priceId;
    }

    public void setPriceId(LongFilter priceId) {
        this.priceId = priceId;
    }

    public LongFilter getProduitId() {
        return produitId;
    }

    public LongFilter produitId() {
        if (produitId == null) {
            produitId = new LongFilter();
        }
        return produitId;
    }

    public void setProduitId(LongFilter produitId) {
        this.produitId = produitId;
    }

    public LongFilter getDeliveredById() {
        return deliveredById;
    }

    public LongFilter deliveredById() {
        if (deliveredById == null) {
            deliveredById = new LongFilter();
        }
        return deliveredById;
    }

    public void setDeliveredById(LongFilter deliveredById) {
        this.deliveredById = deliveredById;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CommandeCriteria that = (CommandeCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(created, that.created) &&
            Objects.equals(state, that.state) &&
            Objects.equals(timeStarted, that.timeStarted) &&
            Objects.equals(timeEnded, that.timeEnded) &&
            Objects.equals(priceId, that.priceId) &&
            Objects.equals(produitId, that.produitId) &&
            Objects.equals(deliveredById, that.deliveredById)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, created, state, timeStarted, timeEnded, priceId, produitId, deliveredById);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CommandeCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (created != null ? "created=" + created + ", " : "") +
            (state != null ? "state=" + state + ", " : "") +
            (timeStarted != null ? "timeStarted=" + timeStarted + ", " : "") +
            (timeEnded != null ? "timeEnded=" + timeEnded + ", " : "") +
            (priceId != null ? "priceId=" + priceId + ", " : "") +
            (produitId != null ? "produitId=" + produitId + ", " : "") +
            (deliveredById != null ? "deliveredById=" + deliveredById + ", " : "") +
            "}";
    }
}
