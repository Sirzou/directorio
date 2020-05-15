package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.PersonBO;
import com.tcs.demo.directorio.dataObjects.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public class PersonService {
    @Autowired
    PersonBO personBO;

    @GetMapping("/person")
    public List<Person> getAllAddresses() {
        return personBO.getAllPersons();
    }

    @GetMapping("/person/{personId}")
    public Person getAddress(@PathVariable String personId) {
        return personBO.getPerson(personId);
    }
}
