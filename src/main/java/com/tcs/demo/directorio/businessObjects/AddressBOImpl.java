package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Address;
import com.tcs.demo.directorio.dataObjects.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBOImpl implements AddressBO {
    @Autowired
    AddressRepository addressRepository;

    public List<Address> getAllAddresses() {
        return (List<Address>) addressRepository.findAll();
    }

    public Address getAddressById(String addressId) {
        return addressRepository.findById(Long.parseLong(addressId)).get();
    }

    @Override
    public Address createAddress(Address address) {
        List<Address> allAddresses = getAllAddresses();
        boolean alreadyExists = allAddresses.stream().anyMatch(add -> add.hashCode() == address.hashCode());
        if (!alreadyExists) {
            try {
                return addressRepository.save(address);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public Address updateAddress(Address address) {
        List<Address> allAddresses = getAllAddresses();
        boolean alreadyExists = allAddresses.stream().anyMatch(add -> add.hashCode() == address.hashCode());
        if (alreadyExists) {
            return addressRepository.save(address);
        }
        return null;
    }
}
