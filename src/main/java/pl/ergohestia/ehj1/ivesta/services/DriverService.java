package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.entities.Driver;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class DriverService{

    private final List<Driver> drivers = new ArrayList<>();

    public List<Driver> getAll() {
        return List.copyOf(drivers);
    }

    public Optional<Driver> findById(UUID id) {
        return drivers.stream()
                .filter(driver -> driver.getId().equals(id))
                .findFirst();
    }
}