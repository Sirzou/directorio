package com.tcs.demo.directorio.dataObjects;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Person {
    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private int age;
    private String bloodType;
}
