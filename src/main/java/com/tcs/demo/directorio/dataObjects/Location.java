package com.tcs.demo.directorio.dataObjects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import java.util.Objects;

@Entity
@Data
public class Location {
    @Id
    @GeneratedValue
    private Long id;
    @OneToOne
    private Person owner;
    @OneToOne
    private Address address;
    private boolean primaryAddress;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location)) return false;
        Location location = (Location) o;
        return getOwner().equals(location.getOwner()) &&
                getAddress().equals(location.getAddress());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getOwner(), getAddress());
    }
}
