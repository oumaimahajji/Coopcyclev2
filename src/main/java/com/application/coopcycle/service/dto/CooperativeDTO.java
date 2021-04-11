package com.application.coopcycle.service.dto;

import java.io.Serializable;
import java.util.Objects;
import javax.validation.constraints.*;

/**
 * A DTO for the {@link com.application.coopcycle.domain.Cooperative} entity.
 */
public class CooperativeDTO implements Serializable {

    private Long id;

    @Size(max = 30)
    private String cooperativeName;

    private String cooperativeCity;

    private String cooperativeAddress;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCooperativeName() {
        return cooperativeName;
    }

    public void setCooperativeName(String cooperativeName) {
        this.cooperativeName = cooperativeName;
    }

    public String getCooperativeCity() {
        return cooperativeCity;
    }

    public void setCooperativeCity(String cooperativeCity) {
        this.cooperativeCity = cooperativeCity;
    }

    public String getCooperativeAddress() {
        return cooperativeAddress;
    }

    public void setCooperativeAddress(String cooperativeAddress) {
        this.cooperativeAddress = cooperativeAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof CooperativeDTO)) {
            return false;
        }

        CooperativeDTO cooperativeDTO = (CooperativeDTO) o;
        if (this.id == null) {
            return false;
        }
        return Objects.equals(this.id, cooperativeDTO.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.id);
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "CooperativeDTO{" +
            "id=" + getId() +
            ", cooperativeName='" + getCooperativeName() + "'" +
            ", cooperativeCity='" + getCooperativeCity() + "'" +
            ", cooperativeAddress='" + getCooperativeAddress() + "'" +
            "}";
    }
}
