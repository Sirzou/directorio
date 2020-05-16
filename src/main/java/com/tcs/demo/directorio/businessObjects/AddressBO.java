package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Domicilio;

import java.util.List;

public interface AddressBO {
    public List<Domicilio> getAllAddresses();

    public Domicilio getAddressById(String addressId);

    public Domicilio createAddress(Domicilio address);

    public Domicilio updateAddress(Domicilio address);
}
