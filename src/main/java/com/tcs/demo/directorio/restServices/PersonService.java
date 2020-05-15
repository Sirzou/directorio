package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.AddressBO;
import com.tcs.demo.directorio.businessObjects.PersonBO;
import com.tcs.demo.directorio.dataObjects.Person;
import com.tcs.demo.directorio.dataObjects.PersonLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PersonService {
    @Autowired
    PersonBO personBO;
    @Autowired
    AddressBO addressBO;

    @GetMapping("/person")
    public List<Person> getAllPersons() {
        return personBO.getAllPersons();
    }

    @GetMapping("/person/{personId}")
    public Person getPerson(@PathVariable String personId) {
        return personBO.getPerson(personId);
    }

    @PostMapping("/person")
    public Person createPerson(@RequestBody Person person){
        return personBO.createPerson(person);
    }

    @PostMapping("/person/{personId}/address/{addressId}")
    public void fetchAddressToPerson(@PathVariable String personId, @PathVariable String addressId){
        Person owner = personBO.getPerson(personId);
        PersonLocation address = addressBO.getAddressById(addressId);
        address.setOwner(owner);
        System.out.println(address);
        PersonLocation updatedAddress = addressBO.updateAddress(address);
        System.out.println(updatedAddress);
    }
}
