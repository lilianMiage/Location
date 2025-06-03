package fr.miage.lroux.location.controller;

import fr.miage.lroux.location.entity.Location;
import fr.miage.lroux.location.service.ServiceLocation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class ControllerLocation {

    @Autowired
    private ServiceLocation serviceLocation;

    @PostMapping("create")
    public Location createLocation(@RequestBody Location location) throws Exception {
        return serviceLocation.createLocation(location);
    }

    @GetMapping("/{id}")
    public Location getLocation(@PathVariable Long id) throws Exception {
        return serviceLocation.getLocationById(id);
    }

}
