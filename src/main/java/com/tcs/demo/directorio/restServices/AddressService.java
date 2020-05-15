package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.AddressBO;
import com.tcs.demo.directorio.dataObjects.PersonLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressService {
    @Autowired
    AddressBO addressBO;

    @GetMapping("/address")
    public List<PersonLocation> getAllAddresses() {
        return addressBO.getAllAddresses();
    }

    @GetMapping("/address/{addressId}")
    public PersonLocation getAddress(@PathVariable String addressId) {
        return addressBO.getAddressById(addressId);
    }

    @PostMapping("/address")
    public PersonLocation createAddress(@RequestBody PersonLocation address){
        return addressBO.createAddress(address);
    }
}
