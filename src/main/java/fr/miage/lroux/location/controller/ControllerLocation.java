package fr.miage.lroux.location.controller;

import fr.miage.lroux.location.entity.Location;
import fr.miage.lroux.location.service.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location/")
public class ControllerLocation {

    @Autowired
    private ServiceLocation serviceLocation;

    @PostMapping("create")
    public Location createLocation(@RequestBody Location location) throws Exception {
        return serviceLocation.createLocation(location);
    }

    @GetMapping("{id}")
    public Location getLocation(@PathVariable long id) throws Exception {
        return serviceLocation.getLocationById(id);
    }

    @GetMapping("active/user/{userId}")
    public Iterable<Location> getLocationActiveByUser(@PathVariable long userId) throws Exception {
        return serviceLocation.getLocationByUserIdAndActive(userId);
    }

    @GetMapping("active/car/{carId}")
    public Iterable<Location> getLocationActiveByVoiture(@PathVariable long carId) throws Exception {
        return serviceLocation.getActiveLocationByVoiture(carId);
    }

    @PutMapping("{id}/update")
    Location updateLocation(@PathVariable long id) throws Exception {
        return serviceLocation.updateLocation(id);
    }
}
