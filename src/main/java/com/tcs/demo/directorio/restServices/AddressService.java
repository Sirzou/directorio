package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.AddressBO;
import com.tcs.demo.directorio.dataObjects.AddressDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AddressService {
    @Autowired
    AddressBO addressBO;

    @GetMapping("/address")
    public List<AddressDO> getAllAddresses() {
        return addressBO.getAllAddresses();
    }

    @GetMapping("/address/{addressId}")
    public AddressDO getAddress(@PathVariable String addressId) {
        return addressBO.getAddressById(addressId);
    }
}
