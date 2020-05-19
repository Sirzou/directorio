package com.tcs.demo.directorio.businessObjects;

import com.tcs.demo.directorio.dataObjects.Address;
import com.tcs.demo.directorio.dataObjects.Person;
import com.tcs.demo.directorio.dataObjects.Location;
import com.tcs.demo.directorio.dataObjects.LocationDORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class LocationBOImpl implements LocationBO {

    @Autowired
    LocationDORepository locationDORepository;

    @Autowired
    PersonBO personBO;

    @Autowired
    AddressBO addressBO;

    public List<Location> getAllLocations() {
        return (List<Location>) locationDORepository.findAll();
    }

    public Location getLocation(Long locationId) {
        return locationDORepository.findById(locationId).get();
    }

    public Location fetchAddressToPerson(String personId, String addressId) {
        Person owner = null;
        Address address = null;
        try {
            owner = personBO.getPerson(personId);
            address = addressBO.getAddressById(addressId);
            if (owner != null && address != null) {
                Location personXLocation = new Location();
                personXLocation.setOwner(owner);
                personXLocation.setAddress(address);
                if (! getAllLocations().stream().anyMatch(location -> location.equals(personXLocation))){
                    return locationDORepository.save(personXLocation);
                }
            }
        } catch (NoSuchElementException nsee) {
            if (owner == null) {
                System.out.println("owner not existent");
            } else if (address == null) {
                System.out.println("address not existent");
            } else {
                System.out.println("Another problem happened");
            }
            System.out.println(nsee.getMessage());
        }
        return null;
    }
}
