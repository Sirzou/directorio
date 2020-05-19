package com.tcs.demo.directorio.restServices;

import com.tcs.demo.directorio.businessObjects.LocationBO;
import com.tcs.demo.directorio.businessObjects.PersonBO;
import com.tcs.demo.directorio.dataObjects.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class LocationService {
    @Autowired
    PersonBO personBO;

    @Autowired
    LocationBO locationBO;

    @GetMapping("/location")
    public ResponseEntity<List<Location>> getAllLocations() {
        List<Location> allLocations = locationBO.getAllLocations();
        if (allLocations != null && !allLocations.isEmpty()) {
            return new ResponseEntity<>(allLocations, HttpStatus.OK);
        }
        return new ResponseEntity<>(allLocations, HttpStatus.NO_CONTENT);
    }

    @PostMapping("/location/fetch-address")
    public ResponseEntity<Location> fetchAddressToPerson(
            @RequestHeader(value = "personId", required = true) String personId,
            @RequestHeader(value = "addressId", required = true) String addressId) {
        Location location = locationBO.fetchAddressToPerson(personId, addressId);
        if (location != null){
            return new ResponseEntity<>(location, HttpStatus.OK);
        }
        return new ResponseEntity<>(location, HttpStatus.CONFLICT);
    }
}
