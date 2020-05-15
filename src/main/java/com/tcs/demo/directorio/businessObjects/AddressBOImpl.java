package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.AddressDO;
import com.tcs.demo.directorio.dataObjects.AddressDORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressBOImpl implements AddressBO {
    @Autowired
    AddressDORepository addressDORepository;

    public List<AddressDO> getAllAddresses() {
        return (List<AddressDO>) addressDORepository.findAll();
    }

    public AddressDO getAddressById(String addressId) {
        return addressDORepository.findById(addressId).get();
    }
}
