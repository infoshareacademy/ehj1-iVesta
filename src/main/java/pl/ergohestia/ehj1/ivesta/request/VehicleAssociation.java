package pl.ergohestia.ehj1.ivesta.request;

import java.util.UUID;

public class VehicleAssociation {

    private final UUID vehicleId;

    public VehicleAssociation(UUID vehicleId) {
        this.vehicleId = vehicleId;
    }

    public UUID getVehicleId() {
        return vehicleId;
    }
}
