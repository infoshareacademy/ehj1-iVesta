package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;
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

    @GetMapping("/availableVehicles/{date}")
    List<VehicleDto> getAvailableVehicles(@PathVariable String date) {
        return vehicleService.getAvailableVehicles(date);
    }

    @GetMapping("/license/{license}")
    public List<VehicleDto> getVehicleByLicense(@PathVariable LicenseType license) {
        return vehicleService.findAllByLicense(license);
    }

}
