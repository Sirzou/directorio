package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.PersonLocation;
import com.tcs.demo.directorio.dataObjects.PersonLocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class AddressBOImpl implements AddressBO {
    @Autowired
    PersonLocationRepository personLocationRepository;

    public List<PersonLocation> getAllAddresses() {
        return (List<PersonLocation>)personLocationRepository.findAll();
    }

    public PersonLocation getAddressById(Long addressId) {
        return personLocationRepository.findById(addressId).get();
    }

    @Override
    public PersonLocation createAddress(PersonLocation address) {
        List<PersonLocation> allAddresses = getAllAddresses();
        boolean alreadyExists = allAddresses.stream().anyMatch(add -> add.hashCode() == address.hashCode());
        if( alreadyExists){
            return null;
        }
        return personLocationRepository.save(address);

    }
}
