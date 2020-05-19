package com.tcs.demo.directorio.dataObjects;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

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
}
