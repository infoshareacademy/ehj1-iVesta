package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.exceptions.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.Availability;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.repository.DriverRepository;

import java.util.List;
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

    public List<DriverDto> getAllDrivers() {
        return driverRepository.findAll()
                .stream()
                .map(driverAdapter::convertToDriverDto)
                .toList();
    }

    public DriverDto getDriverById(UUID id) {
        var driver = findById(id);
        return driverAdapter.convertToDriverDto(driver);
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

    public DriverDto setStatus(UUID id, Availability availability) {
        var driver = findById(id);
        driver.setAvailability(availability);
        Driver newDriver = driverRepository.save(driver);
        return driverAdapter.convertToDriverDto(newDriver);
    }

    private Driver findById(UUID id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(format("Driver with id %s not found.", id)));
    }

    private Driver updateDriverData(Driver foundDriver, DriverDto driverDto) {
        String name = driverDto.getName();
        String lastName = driverDto.getLastName();
        String phoneNumber = driverDto.getPhoneNumber();
        String license = driverDto.getLicense();

        if (name != null && !name.isBlank()) {
            foundDriver.setName(name);
        }
        if (lastName != null && !lastName.isBlank()) {
            foundDriver.setLastName(lastName);
        }
        if (phoneNumber != null && !phoneNumber.isBlank()) {
            foundDriver.setPhoneNumber(phoneNumber);
        }
        if (license != null && !license.isBlank()) {
            foundDriver.setLicense(license);
        }
        return foundDriver;
    }
}