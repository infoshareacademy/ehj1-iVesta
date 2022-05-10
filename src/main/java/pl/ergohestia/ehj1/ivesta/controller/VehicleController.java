package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.Availability;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
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
    public VehicleDto getVehicleById(@PathVariable UUID id) {
        return vehicleService.getVehicleById(id);
    }

    @PostMapping
    public VehicleDto addNewVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable UUID id) {
        vehicleService.deleteById(id);
    }

    @PutMapping("/{id}")
    public VehicleDto updateVehicle(@PathVariable UUID id, @RequestBody VehicleDto vehicleDto) {
        return vehicleService.updateVehicle(id, vehicleDto);
    }
    @PutMapping("/activate/{id}")
    ResponseEntity<VehicleDto> setStatusToActive(@PathVariable UUID id) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.setVehicleStatus((id),Availability.ACTIVE));
    }
    @PutMapping("/deactivate/{id}")
    ResponseEntity<VehicleDto> setStatusToInactive(@PathVariable UUID id,Availability availability) {
        return ResponseEntity.status(HttpStatus.OK).body(vehicleService.setVehicleStatus((id),Availability.INACTIVE));
    }
    @GetMapping("/cargo/{transport}")
    List<VehicleDto> getVehicleByTransportType(@PathVariable String transport){
        return vehicleService.getVehicleByCargoType(transport);
    }
}
