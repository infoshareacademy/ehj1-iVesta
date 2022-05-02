package pl.ergohestia.ehj1.ivesta.adapters;

import org.springframework.stereotype.Component;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
@Component
public class VehicleAdapter {
    public VehicleDto convertToVehicleDto(Vehicle vehicle) {
        if (vehicle == null) return null;
        VehicleDto vehicleDto = new VehicleDto(
                vehicle.getBrand(),
                vehicle.getVehicleCategory(),
                vehicle.getModel(),
                vehicle.getNumberOfSeats(),
                vehicle.getFuelType(),
                vehicle.getWeightLimit());
        vehicleDto.setId(vehicle.getId());
        return vehicleDto;
    }

    public Vehicle convertToVehicle(VehicleDto vehicleDto) {
        if (vehicleDto == null) return null;
        Vehicle vehicle = new Vehicle(
                vehicleDto.getBrand(),
                vehicleDto.getVehicleCategory(),
                vehicleDto.getModel(),
                vehicleDto.getNumberOfSeats(),
                vehicleDto.getFuelType(),
                vehicleDto.getWeightLimit());
        vehicle.setId(vehicleDto.getId());
        return vehicle;
    }
}