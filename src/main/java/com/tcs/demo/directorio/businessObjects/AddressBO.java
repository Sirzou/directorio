package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Address;

import java.util.List;

public interface AddressBO {

    public List<Address> getAllAddresses();

    public Address getAddressById(String addressId);

    public Address createAddress(Address address);

    public Address updateAddress(Address address);
}
