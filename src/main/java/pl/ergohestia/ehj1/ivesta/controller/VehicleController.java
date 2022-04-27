package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {


    private final VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    List<VehicleDto> getVehicle() {
        return vehicleService.findAll();
    }

    @GetMapping("/{id}")
    ResponseEntity<VehicleDto> getVehicle(@PathVariable UUID id) {
        throw new RuntimeException();
    }

    @PostMapping
    ResponseEntity<VehicleDto> addNewVehicle(@RequestBody VehicleDto vehicleDto) {
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteVehicle(@PathVariable UUID id) {
        throw new RuntimeException();
    }

    @PutMapping("/{id}")
    ResponseEntity<VehicleDto> updateVehicle(@PathVariable UUID id, @RequestBody VehicleDto vehicleDto) {
        throw new RuntimeException();
    }
}
