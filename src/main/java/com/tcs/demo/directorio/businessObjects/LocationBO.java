package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Location;

import java.util.List;

public interface LocationBO {
    List<Location> getAllLocations();

    Location getLocation(Long locationId);

    Location fetchAddressToPerson(String personId, String addressId);
}
