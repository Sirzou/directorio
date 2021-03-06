package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonBOImpl implements PersonBO {

    @Autowired
    PersonDORepository personDORepository;

    @Autowired
    AddressBO addressBO;

    @Autowired
    LocationDORepository locationDORepository;

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personDORepository.findAll();
    }

    @Override
    public Person getPerson(String personId) {
        return personDORepository.findById(Long.parseLong(personId)).get();
    }

    @Override
    public Person createPerson(Person person) {
        return personDORepository.save(person);
    }

}
