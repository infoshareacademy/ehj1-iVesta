package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.exception.ResourceNotFound;
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

    public VehicleDto getVehicleById(UUID id) {
        return vehicleRepository.findById(id)
                .map(vehicleAdapter::convertToVehicleDto)
                .orElseThrow(() -> new ResourceNotFound("Vehicle not found."));
    }

    public VehicleDto addVehicle(Vehicle vehicle) {
        Vehicle savedVehicle = vehicleRepository.save(vehicle);
        return vehicleAdapter.convertToVehicleDto(savedVehicle);
    }
    public void deleteById(UUID id) {
        if(vehicleRepository.existsById(id)){
            vehicleRepository.deleteById(id);
        }else throw new ResourceNotFound("Id does not exist in database.");
    }

    public VehicleDto updateVehicle(UUID id, VehicleDto vehicleDto) {
        return vehicleRepository.findById(id)
                .map(vehicle -> {
                    if (vehicleDto.getBrand() != null && !vehicleDto.getBrand().isBlank()){
                    vehicle.setBrand(vehicleDto.getBrand());}

                    if (vehicleDto.getLicense() != null){
                    vehicle.setLicense(vehicleDto.getLicense());}

                    if (vehicleDto.getModel() != null && !vehicleDto.getModel().isBlank()){
                    vehicle.setModel(vehicleDto.getModel());}

                    if (vehicleDto.getFuelType() != null && !vehicleDto.getFuelType().isBlank()){
                    vehicle.setFuelType(vehicleDto.getFuelType());}

                    if (vehicleDto.getNumberOfSeats() != 0){
                    vehicle.setNumberOfSeats(vehicleDto.getNumberOfSeats());}

                    if (vehicleDto.getWeightLimit() != 0){
                    vehicle.setWeightLimit(vehicleDto.getWeightLimit());}

                    return vehicleAdapter.convertToVehicleDto(vehicleRepository.save(vehicle));
          })
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_MODIFIED,"Nothing was changed."));
    }
}
