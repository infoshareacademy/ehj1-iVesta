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
}
