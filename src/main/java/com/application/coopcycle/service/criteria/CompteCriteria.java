package com.application.coopcycle.service.criteria;

import com.application.coopcycle.domain.enumeration.Role;
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
 * Criteria class for the {@link com.application.coopcycle.domain.Compte} entity. This class is used
 * in {@link com.application.coopcycle.web.rest.CompteResource} to receive all the possible filtering options from
 * the Http GET request parameters.
 * For example the following could be a valid request:
 * {@code /comptes?id.greaterThan=5&attr1.contains=something&attr2.specified=false}
 * As Spring is unable to properly convert the types, unless specific {@link Filter} class are used, we need to use
 * fix type specific filters.
 */
public class CompteCriteria implements Serializable, Criteria {

    /**
     * Class for filtering Role
     */
    public static class RoleFilter extends Filter<Role> {

        public RoleFilter() {}

        public RoleFilter(RoleFilter filter) {
            super(filter);
        }

        @Override
        public RoleFilter copy() {
            return new RoleFilter(this);
        }
    }

    private static final long serialVersionUID = 1L;

    private LongFilter id;

    private StringFilter name;

    private StringFilter surname;

    private StringFilter email;

    private RoleFilter categorie;

    private StringFilter phoneNumber;

    private StringFilter address;

    private StringFilter postalCode;

    private StringFilter city;

    private LongFilter panierId;

    private LongFilter commandeId;

    private LongFilter memberOfId;

    public CompteCriteria() {}

    public CompteCriteria(CompteCriteria other) {
        this.id = other.id == null ? null : other.id.copy();
        this.name = other.name == null ? null : other.name.copy();
        this.surname = other.surname == null ? null : other.surname.copy();
        this.email = other.email == null ? null : other.email.copy();
        this.categorie = other.categorie == null ? null : other.categorie.copy();
        this.phoneNumber = other.phoneNumber == null ? null : other.phoneNumber.copy();
        this.address = other.address == null ? null : other.address.copy();
        this.postalCode = other.postalCode == null ? null : other.postalCode.copy();
        this.city = other.city == null ? null : other.city.copy();
        this.panierId = other.panierId == null ? null : other.panierId.copy();
        this.commandeId = other.commandeId == null ? null : other.commandeId.copy();
        this.memberOfId = other.memberOfId == null ? null : other.memberOfId.copy();
    }

    @Override
    public CompteCriteria copy() {
        return new CompteCriteria(this);
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

    public StringFilter getName() {
        return name;
    }

    public StringFilter name() {
        if (name == null) {
            name = new StringFilter();
        }
        return name;
    }

    public void setName(StringFilter name) {
        this.name = name;
    }

    public StringFilter getSurname() {
        return surname;
    }

    public StringFilter surname() {
        if (surname == null) {
            surname = new StringFilter();
        }
        return surname;
    }

    public void setSurname(StringFilter surname) {
        this.surname = surname;
    }

    public StringFilter getEmail() {
        return email;
    }

    public StringFilter email() {
        if (email == null) {
            email = new StringFilter();
        }
        return email;
    }

    public void setEmail(StringFilter email) {
        this.email = email;
    }

    public RoleFilter getCategorie() {
        return categorie;
    }

    public RoleFilter categorie() {
        if (categorie == null) {
            categorie = new RoleFilter();
        }
        return categorie;
    }

    public void setCategorie(RoleFilter categorie) {
        this.categorie = categorie;
    }

    public StringFilter getPhoneNumber() {
        return phoneNumber;
    }

    public StringFilter phoneNumber() {
        if (phoneNumber == null) {
            phoneNumber = new StringFilter();
        }
        return phoneNumber;
    }

    public void setPhoneNumber(StringFilter phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public StringFilter getAddress() {
        return address;
    }

    public StringFilter address() {
        if (address == null) {
            address = new StringFilter();
        }
        return address;
    }

    public void setAddress(StringFilter address) {
        this.address = address;
    }

    public StringFilter getPostalCode() {
        return postalCode;
    }

    public StringFilter postalCode() {
        if (postalCode == null) {
            postalCode = new StringFilter();
        }
        return postalCode;
    }

    public void setPostalCode(StringFilter postalCode) {
        this.postalCode = postalCode;
    }

    public StringFilter getCity() {
        return city;
    }

    public StringFilter city() {
        if (city == null) {
            city = new StringFilter();
        }
        return city;
    }

    public void setCity(StringFilter city) {
        this.city = city;
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

    public LongFilter getMemberOfId() {
        return memberOfId;
    }

    public LongFilter memberOfId() {
        if (memberOfId == null) {
            memberOfId = new LongFilter();
        }
        return memberOfId;
    }

    public void setMemberOfId(LongFilter memberOfId) {
        this.memberOfId = memberOfId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CompteCriteria that = (CompteCriteria) o;
        return (
            Objects.equals(id, that.id) &&
            Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname) &&
            Objects.equals(email, that.email) &&
            Objects.equals(categorie, that.categorie) &&
            Objects.equals(phoneNumber, that.phoneNumber) &&
            Objects.equals(address, that.address) &&
            Objects.equals(postalCode, that.postalCode) &&
            Objects.equals(city, that.city) &&
            Objects.equals(panierId, that.panierId) &&
            Objects.equals(commandeId, that.commandeId) &&
            Objects.equals(memberOfId, that.memberOfId)
        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, surname, email, categorie, phoneNumber, address, postalCode, city, panierId, commandeId, memberOfId);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompteCriteria{" +
            (id != null ? "id=" + id + ", " : "") +
            (name != null ? "name=" + name + ", " : "") +
            (surname != null ? "surname=" + surname + ", " : "") +
            (email != null ? "email=" + email + ", " : "") +
            (categorie != null ? "categorie=" + categorie + ", " : "") +
            (phoneNumber != null ? "phoneNumber=" + phoneNumber + ", " : "") +
            (address != null ? "address=" + address + ", " : "") +
            (postalCode != null ? "postalCode=" + postalCode + ", " : "") +
            (city != null ? "city=" + city + ", " : "") +
            (panierId != null ? "panierId=" + panierId + ", " : "") +
            (commandeId != null ? "commandeId=" + commandeId + ", " : "") +
            (memberOfId != null ? "memberOfId=" + memberOfId + ", " : "") +
            "}";
    }
}
