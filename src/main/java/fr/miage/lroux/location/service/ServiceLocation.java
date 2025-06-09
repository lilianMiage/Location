package fr.miage.lroux.location.service;

import fr.miage.lroux.location.entity.Location;
import fr.miage.lroux.location.repository.RepoLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ServiceLocation {
    @Autowired
    private RepoLocation repoLocation;

    public Location createLocation(Location location) throws Exception {
        Optional<Location> locationOptional = repoLocation.findById(location.getIdLocation());
        if (locationOptional.isPresent()) {
            throw new Exception("A location with this ID " + location.getIdLocation() + " already exists");
        }
        repoLocation.save(location);
        return location;
    }

    public Iterable<Location> getLocationByUserIdAndActive(Long locationId) throws Exception {
        return repoLocation.findByUserId(locationId);
    }

    public Iterable<Location> getActiveLocationByVoiture(Long carId) {
        return repoLocation.findByCarId(carId);
    }

    public Location getLocationById(Long locationId) throws Exception {
        Optional<Location> locationOptional = repoLocation.findById(locationId);
        if (locationOptional.isEmpty()) {
            throw new Exception("A location with this ID " + locationId + " does not exist");
        }
        return locationOptional.get();
    }
}
