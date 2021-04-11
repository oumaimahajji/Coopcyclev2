package com.application.coopcycle.service.dto;

import com.application.coopcycle.domain.enumeration.Role;
import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Compte} entity.
 */
public class CompteDTO implements Serializable {

    private Long id;

    @NotNull
    private String name;

    @NotNull
    private String surname;

    @NotNull
    @Pattern(regexp = "^([a-zA-Z0-9_\\-\\.]+)@(|gmail|imag|hotmail|yahoo+)\\.(fr|com)$")
    private String email;

    private Role categorie;

    @Size(min = 10, max = 10)
    private String phoneNumber;

    @Size(max = 100)
    private String address;

    @Size(min = 5, max = 5)
    private String postalCode;

    @Size(max = 30)
    private String city;

    private CooperativeDTO memberOf;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Role getCategorie() {
        return categorie;
    }

    public void setCategorie(Role categorie) {
        this.categorie = categorie;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CooperativeDTO getMemberOf() {
        return memberOf;
    }

    public void setMemberOf(CooperativeDTO memberOf) {
        this.memberOf = memberOf;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CompteDTO)) {
            return false;
        }

        CompteDTO compteDTO = (CompteDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, compteDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CompteDTO{" +
            "id=" + getId() +
            ", name='" + getName() + "'" +
            ", surname='" + getSurname() + "'" +
            ", email='" + getEmail() + "'" +
            ", categorie='" + getCategorie() + "'" +
            ", phoneNumber='" + getPhoneNumber() + "'" +
            ", address='" + getAddress() + "'" +
            ", postalCode='" + getPostalCode() + "'" +
            ", city='" + getCity() + "'" +
            ", memberOf=" + getMemberOf() +
            "}";
    }
}
