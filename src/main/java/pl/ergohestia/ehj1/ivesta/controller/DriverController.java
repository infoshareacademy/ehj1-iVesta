package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.Availability;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.services.DriverService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
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

    @PostMapping
    ResponseEntity<DriverDto> addNewDriver(@RequestBody Driver driver) {
        return ResponseEntity.status(HttpStatus.CREATED).body(driverService.addDriver(driver));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteDriver(@PathVariable UUID id) {
        driverService.deleteDriverById(id);
    }

    @PutMapping("/{id}")
    public DriverDto updateDriver(@PathVariable UUID id, @RequestBody DriverDto driverDto) {
        return driverService.updateDriverById(id, driverDto);
    }

    @PutMapping("/activate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStatusToActive(@PathVariable UUID id) {
        driverService.setStatus(id, Availability.ACTIVE);
    }

    @PutMapping("/deactivate/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void setStatusToInactive(@PathVariable UUID id) {
        driverService.setStatus(id, Availability.INACTIVE);
    }

    @GetMapping("/availableDrivers/{date}")
    List<DriverDto> getAvailableDrivers(@PathVariable String date){
        return driverService.getAvailableDrivers(date);
    }
}
