package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.PersonLocation;

import java.util.List;

public interface AddressBO {
    public List<PersonLocation> getAllAddresses();

    public PersonLocation getAddressById(String addressId);

    public PersonLocation createAddress(PersonLocation address);

    public PersonLocation updateAddress(PersonLocation address);
}
