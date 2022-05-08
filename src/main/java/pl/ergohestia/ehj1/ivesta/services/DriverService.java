package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.exceptions.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.repository.DriverRepository;
import pl.ergohestia.ehj1.ivesta.repository.RouteRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
public class DriverService {

    private final DriverRepository driverRepository;
    private final DriverAdapter driverAdapter;
    private final RouteRepository routeRepository;

    public DriverService(DriverRepository driverRepository, DriverAdapter driverAdapter, RouteRepository routeRepository) {
        this.driverRepository = driverRepository;
        this.driverAdapter = driverAdapter;
        this.routeRepository = routeRepository;
    }

    public Driver findById(UUID id) {
        return driverRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(format("Driver with id %s not found.", id)));
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

    public DriverDto setStatus(UUID id, Boolean status) {
        var driver = findById(id);
        driver.setActive(status);
        Driver newDriver = driverRepository.save(driver);
        return driverAdapter.convertToDriverDto(newDriver);
    }

    public List<DriverDto> getAvailableDrivers(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        List<Driver> allDrivers = driverRepository.findAll();
        List<Driver> availableDrivers = new java.util.ArrayList<>(List.copyOf(allDrivers));
        List<Route> routes = routeRepository.findAllByDriverNotNullAndDate(date);

        for (Route route : routes) {
            UUID id = route.getDriver().getId();
            for (Driver driver : allDrivers) {
                if (id.equals(driver.getId())) {
                    availableDrivers.remove(driver);
                }
            }
        }

        return availableDrivers
                .stream()
                .map(driverAdapter::convertToDriverDto)
                .toList();
    }
}