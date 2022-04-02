package pl.ergohestia.ehj1.ivesta.adapters;

import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

public class VehicleAdapter {
    public VehicleDto convertToVehicleDto(Vehicle vehicle) {
        if (vehicle == null) return null;
        VehicleDto vehicleDto = new VehicleDto(vehicle.getBrand(),
                vehicle.getVehicleCategory(),
                vehicle.getModel(),
                vehicle.getVehicleType(),
                vehicle.getProductionMethod(),
                vehicle.getProductionYear(),
                vehicle.getEngineCapacity(),
                vehicle.getEnginePower(),
                vehicle.getHybridEnginePower(),
                vehicle.getNumberOfSeats(),
                vehicle.getFuelType(),
                vehicle.getFuelConsumption(),
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
                vehicleDto.getVehicleType(),
                vehicleDto.getProductionMethod(),
                vehicleDto.getProductionYear(),
                vehicleDto.getEngineCapacity(),
                vehicleDto.getEnginePower(),
                vehicleDto.getHybridEnginePower(),
                vehicleDto.getNumberOfSeats(),
                vehicleDto.getFuelType(),
                vehicleDto.getFuelConsumption(),
                vehicleDto.getWeightLimit());
        vehicleDto.setId(vehicleDto.getId());
        return vehicle;
    }
}