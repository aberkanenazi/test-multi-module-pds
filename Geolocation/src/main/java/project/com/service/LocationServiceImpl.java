package project.com.service;

import project.com.model.Location;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.com.persistance.LocationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class LocationServiceImpl implements ServiceImpl<Location> {

    private LocationRepository locationRepository;

    @Autowired
    public void setLocationRepository(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public Location save(Location location) {
        return this.locationRepository.save(location);
    }

    @Override
    public List<Location> findAll() {
        return this.locationRepository.findAll();
    }

    @Override
    public Optional<Location> findById(String id) {
        return this.locationRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        this.locationRepository.deleteAll();
    }

    @Override
    public void deleteById(String id) {
        this.locationRepository.deleteById(id);
    }

    public Location findLast() {
        List<Location> locationList = this.locationRepository.findAll();
        Location location = locationList.get(locationList.size() - 1);
        return location;
    }
}
