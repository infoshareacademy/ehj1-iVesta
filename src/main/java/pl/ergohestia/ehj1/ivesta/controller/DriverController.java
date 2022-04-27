package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.services.DriverService;

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
    List<DriverDto> getDrivers(){
        throw new RuntimeException();
    }

    @GetMapping("/{id}")
    ResponseEntity<DriverDto> getDriver(@PathVariable UUID id){
        throw new RuntimeException();
    }

    @PostMapping
    ResponseEntity<DriverDto> addNewDriver(@RequestBody DriverDto driverDto){
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteDriver(@PathVariable UUID id){
        throw new RuntimeException();
    }

    @PutMapping("/{id}")
    ResponseEntity<DriverDto> updateDriver(@PathVariable UUID id, @RequestBody DriverDto driverDto){
        throw new RuntimeException();
    }
    @PutMapping("/{id}/active")
    ResponseEntity<DriverDto> setStatusToActive(@PathVariable UUID id, @RequestBody DriverDto driverDto){
        throw new RuntimeException();
    }

    @PutMapping("/{id}/inactive")
    ResponseEntity<DriverDto> setStatusToInactive(@PathVariable UUID id, @RequestBody DriverDto driverDto){
        throw new RuntimeException();
    }
}
