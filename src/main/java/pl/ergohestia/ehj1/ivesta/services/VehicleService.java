package pl.ergohestia.ehj1.ivesta.services;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;
import pl.ergohestia.ehj1.ivesta.exceptions.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.RouteRepository;
import pl.ergohestia.ehj1.ivesta.repository.VehicleRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Service
public class VehicleService {

    private final VehicleRepository vehicleRepository;
    private final VehicleAdapter vehicleAdapter;
    private final RouteRepository routeRepository;

    public VehicleService(VehicleRepository vehicleRepository, VehicleAdapter vehicleAdapter, RouteRepository routeRepository) {
        this.vehicleRepository = vehicleRepository;
        this.vehicleAdapter = vehicleAdapter;
        this.routeRepository = routeRepository;
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

    public List<VehicleDto> getAvailableVehicles(String dateStr) {
        LocalDate date = LocalDate.parse(dateStr);
        List<Vehicle> allVehicles = vehicleRepository.findAll();
        List<Vehicle> availableVehicles = new java.util.ArrayList<>(List.copyOf(allVehicles));
        List<Route> routes = routeRepository.findAllByVehicleNotNullAndDate(date);

        for (Route route : routes) {
            UUID id = route.getVehicle().getId();
            for (Vehicle vehicle : allVehicles) {
                if (id.equals(vehicle.getId())) {
                    availableVehicles.remove(vehicle);
                }
            }
        }

        return availableVehicles
                .stream()
                .map(vehicleAdapter::convertToVehicleDto)
                .toList();
    }

    public List<VehicleDto> findAllByLicense(LicenseType license) {

        return vehicleRepository.findAllByLicense(license)
                .stream()
                .map(vehicleAdapter::convertToVehicleDto)
                .toList();
    }
}
