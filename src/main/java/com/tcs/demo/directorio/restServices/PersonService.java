package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.AddressBO;
import com.tcs.demo.directorio.businessObjects.PersonBO;
import com.tcs.demo.directorio.dataObjects.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class PersonService {
    @Autowired
    PersonBO personBO;
    @Autowired
    AddressBO addressBO;

    @GetMapping("/person")
    public ResponseEntity<List<Person>> getAllPersons() {
        List<Person> allPersons = personBO.getAllPersons();
        if (allPersons != null && !allPersons.isEmpty()) {
            return new ResponseEntity<>(allPersons, HttpStatus.OK);
        }
        return new ResponseEntity<>(allPersons, HttpStatus.NO_CONTENT);
    }

    @GetMapping("/person/{personId}")
    public ResponseEntity<Person> getPerson(@PathVariable String personId) {
        Person person = personBO.getPerson(personId);
        if (person != null) {
            return new ResponseEntity<Person>(person, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/person")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        try {
            Person newPerson = personBO.createPerson(person);
            if (newPerson != null) {
                return new ResponseEntity<>(newPerson, HttpStatus.OK);
            }
        } catch (EntityNotFoundException enfe) {
            System.out.println(enfe.getMessage());
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(null, HttpStatus.CONFLICT);
    }


}
