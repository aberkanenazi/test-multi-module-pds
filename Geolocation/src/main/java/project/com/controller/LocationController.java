package project.com.controller;

import lombok.extern.slf4j.Slf4j;
import project.com.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import project.com.service.LocationServiceImpl;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/api/v1/locations")
public class LocationController {

    private LocationServiceImpl locationService;

    @Autowired
    public void setLocationService(LocationServiceImpl locationService) {
        this.locationService = locationService;
    }

    @GetMapping("/")
    public List<Location> findAll() {
        List<Location> locations = this.locationService.findAll();
        return locations;
    }

    @PostMapping
    @ResponseBody
    public ResponseEntity<Location> save(@RequestBody Location location, UriComponentsBuilder uriComponentsBuilder) {
        this.locationService.save(location);
        UriComponents uriComponents = uriComponentsBuilder.path("/api/v1/locations/{id}").buildAndExpand(location.getLocationId());
        return ResponseEntity.status(HttpStatus.CREATED)
                .location(uriComponents.toUri())
                .body(location);
    }

    @GetMapping("/last")
    public Location getLocation() {
        Location location = this.locationService.findLast();
        return location;
    }

    @DeleteMapping("/{locationId}")
    public void delete(@PathVariable("locationId") String locationId) {
        this.locationService.deleteById(locationId);
    }
}

