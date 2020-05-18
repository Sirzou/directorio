package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Address;
import com.tcs.demo.directorio.dataObjects.Person;
import com.tcs.demo.directorio.dataObjects.PersonDORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class PersonBOImpl implements PersonBO{

    @Autowired
    PersonDORepository personDORepository;

    @Autowired
    AddressBO addressBO;

    @Override
    public List<Person> getAllPersons() {
        return (List<Person>) personDORepository.findAll();
    }

    @Override
    public Person getPerson(String  personId) {
        return personDORepository.findById(Long.parseLong(personId)).get();
    }

    @Override
    public Person createPerson(Person person) {
        return personDORepository.save(person);
    }

    public Address fetchAddressToPerson(String personId, String addressId){
        Person owner = null;
        Address address = null;
        try {
            owner = getPerson(personId);
            address = addressBO.getAddressById(addressId);
            if (owner != null && address != null) {
                address.setOwner(owner);
                Address domicilio = addressBO.updateAddress(address);
                return domicilio;
            }
        }catch(NoSuchElementException nsee){
            if(owner==null){
                System.out.println("owner not existent");
            }else if(address == null){
                System.out.println("address not existent");
            }else{
                System.out.println("Another problem happened");
            }
            System.out.println(nsee.getMessage());
        }finally {
            return null;
        }

    }
}
