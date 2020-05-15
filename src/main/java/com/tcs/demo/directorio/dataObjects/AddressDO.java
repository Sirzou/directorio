package com.tcs.demo.directorio.bo;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "ADDRESS")
public class AddressDO {
    @Id
    @GeneratedValue
    private static String id;
    private static String street;
    private static String externalNumber;
    private static String internalNumber;
    private static String postalCode;
    private static String locality;
    private static String city;
    private static String state;
    private static String country;

}
