package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Address;
import com.tcs.demo.directorio.dataObjects.Person;

import java.util.List;

public interface PersonBO {
    public List<Person> getAllPersons();
    public Person getPerson(String personId);
    public Person createPerson(Person person);
    public Address fetchAddressToPerson(String personId, String addressId);
}
