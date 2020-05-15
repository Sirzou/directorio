package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.AddressDO;

import java.util.List;

public interface AddressBO {
    public List<AddressDO> getAllAddresses();

    public AddressDO getAddressById(String addressId);
}
