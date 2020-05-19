package com.tcs.demo.directorio.dataObjects;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Data
public class Address {
    @Id
    @GeneratedValue
    private Long id;
    private String street;
    private String externalNumber;
    private String internalNumber;
    private String postalCode;
    private String locality;
    private String city;
    private String state;
    private String country;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address that = (Address) o;
        return street.equals(that.street) &&
                externalNumber.equals(that.externalNumber) &&
                Objects.equals(internalNumber, that.internalNumber) &&
                postalCode.equals(that.postalCode) &&
                locality.equals(that.locality) &&
                city.equals(that.city) &&
                state.equals(that.state) &&
                country.equals(that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(street, externalNumber, internalNumber, postalCode, locality, city, state, country);
    }
}
