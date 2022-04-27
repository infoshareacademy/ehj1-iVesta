package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.exceptions.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.repository.DriverRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static java.lang.String.format;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverAdapter driverAdapter;

    public DriverService(DriverRepository driverRepository, DriverAdapter driverAdapter) {
        this.driverRepository = driverRepository;
        this.driverAdapter = driverAdapter;
    }

    private Driver findById(UUID id) {
        return driverRepository.findById(id)
                .stream()
                .filter(driver -> driver.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResourceNotFound(format("Driver with id %d not found.", id)));
    }

    public List<DriverDto> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .map(driverAdapter::convertToDriverDto)
                .toList();
    }

    public Optional<DriverDto> getDriverById(UUID id) {
        return driverRepository.findById(id)
                .stream()
                .filter(driver -> driver.getId().equals(id))
                .findFirst()
                .map(driverAdapter::convertToDriverDto);
    }

    public DriverDto addDriver(Driver driver) {
        Driver newDriver = driverRepository.save(driver);
        return driverAdapter.convertToDriverDto(newDriver);
    }

    public void deleteDriverById(UUID id) {
        driverRepository.deleteById(id);
    }

    public DriverDto updateDriverById(UUID id, DriverDto driverDto) {
        var driver = findById(id);
        var updatedDriver = updateDriverData(driver, driverDto);
        Driver newDriver = driverRepository.save(updatedDriver);
        return driverAdapter.convertToDriverDto(newDriver);
    }

    private Driver updateDriverData(Driver foundDriver, DriverDto driverDto) {
        String name = foundDriver.getName();
        String lastName = foundDriver.getLastName();
        String address = foundDriver.getAddress();
        String phoneNumber = foundDriver.getPhoneNumber();
        String license = foundDriver.getLicense();

        if (!name.isBlank()) {
            foundDriver.setName(name);
        }
        if (!lastName.isBlank()) {
            foundDriver.setLastName(driverDto.getLastName());
        }
        if (!address.isBlank()) {
            foundDriver.setAddress(driverDto.getAddress());
        }
        if (!phoneNumber.isBlank()) {
            foundDriver.setPhoneNumber(driverDto.getPhoneNumber());
        }
        if (!license.isBlank()) {
            foundDriver.setLicense(driverDto.getLicense());
        }
        return foundDriver;
    }

    public DriverDto setStatus(UUID id, Boolean status) {
        var driver = findById(id);
        driver.setActive(status);
        Driver newDriver = driverRepository.save(driver);
        return driverAdapter.convertToDriverDto(newDriver);
    }
}