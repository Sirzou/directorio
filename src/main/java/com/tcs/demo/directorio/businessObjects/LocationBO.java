package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Location;

import java.util.List;

public interface LocationBO {
    public List<Location> getAllLocations();
    public Location getLocation(Long locationId);
    public Location fetchAddressToPerson(String personId, String addressId);
}
