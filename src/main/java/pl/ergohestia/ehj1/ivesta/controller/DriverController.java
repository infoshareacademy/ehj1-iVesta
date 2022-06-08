package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.Availability;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.services.DriverService;

import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/drivers")
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping
    List<DriverDto> getDrivers() {
        return driverService.getAllDrivers();
    }

    @GetMapping("/{id}")
    public DriverDto getDriver(@PathVariable UUID id) {
        return driverService.getDriverById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable UUID id) {
        try {
            driverService.deleteById(id);
        } catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Driver not found.", exception);
        }
    }

    @PostMapping
    ResponseEntity<DriverDto> addNewDriver(@RequestBody Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.addDriver(driver));
    }

    @PutMapping("/{id}")
    public DriverDto updateDriver(@PathVariable UUID id, @RequestBody DriverDto driverDto) {
        return driverService.updateDriverById(id, driverDto);
    }

    @PutMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStatusToActive(@PathVariable UUID id) {
        driverService.setDriverStatus(id, Availability.ACTIVE);
    }

    @PutMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStatusToInactive(@PathVariable UUID id) {
        driverService.setDriverStatus(id, Availability.INACTIVE);
    }

    @GetMapping("/availableDrivers/{date}")
    List<DriverDto> getAvailableDrivers(@PathVariable String date) {
        return driverService.getAvailableDrivers(date);
    }
}
