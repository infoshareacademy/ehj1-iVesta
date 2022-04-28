package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.VehicleRepository;

import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleAdapter vehicleAdapter;

    public VehicleService(VehicleRepository vehicleRepository, VehicleAdapter vehicleAdapter) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleAdapter = vehicleAdapter;
    }

    public List<VehicleDto> findAll() {
        return vehicleRepository.findAll()
                .stream()
                .map(vehicleAdapter::convertToVehicleDto)
                .toList();
    }

    public Vehicle getVehicleById(UUID id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Unable to find vehicle."));
    }

    public VehicleDto addVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleAdapter.convertToVehicleDto(savedVehicle);
    }

    public void deleteById(UUID id) {
        vehicleRepository.deleteById(id);
    }

    public VehicleDto updateVehicle(UUID id, VehicleDto vehicleDto) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    vehicle.setBrand(vehicleDto.getBrand());
                    vehicle.setVehicleCategory(vehicleDto.getVehicleCategory());
                    vehicle.setModel(vehicleDto.getModel());
                    vehicle.setFuelType(vehicleDto.getFuelType());
                    vehicle.setNumberOfSeats(vehicleDto.getNumberOfSeats());
                    vehicle.setWeightLimit(vehicleDto.getWeightLimit());
                    return vehicleAdapter.convertToVehicleDto(vehicleRepository.save(vehicle));
          })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_MODIFIED,"Nothing was changed."));
    }
}
