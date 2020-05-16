package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Domicilio;
import com.tcs.demo.directorio.dataObjects.DomicilioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBOImpl implements AddressBO {
    @Autowired
    DomicilioRepository domicilioRepository;

    public List<Domicilio> getAllAddresses() {
        return (List<Domicilio>) domicilioRepository.findAll();
    }

    public Domicilio getAddressById(String addressId) {
        return domicilioRepository.findById(Long.parseLong(addressId)).get();
    }

    @Override
    public Domicilio createAddress(Domicilio address) {
        List<Domicilio> allAddresses = getAllAddresses();
        boolean alreadyExists = allAddresses.stream().anyMatch(add -> add.hashCode() == address.hashCode());
        if (!alreadyExists) {
            try {
                return domicilioRepository.save(address);
            }catch(Exception e){
                System.out.println(e);
            }
        }
        return null;
    }

    @Override
    public Domicilio updateAddress(Domicilio address) {
        List<Domicilio> allAddresses = getAllAddresses();
        boolean alreadyExists = allAddresses.stream().anyMatch(add -> add.hashCode() == address.hashCode());
        if (alreadyExists) {
            return domicilioRepository.save(address);
        }
        return null;
    }
}
