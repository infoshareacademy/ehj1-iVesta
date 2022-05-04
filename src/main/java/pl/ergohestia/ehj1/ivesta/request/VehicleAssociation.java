package pl.ergohestia.ehj1.ivesta.request;

import java.util.UUID;

public record VehicleAssociation(UUID vehicleId) {
    public UUID getVehicleId() {
        return vehicleId;
    }
}
