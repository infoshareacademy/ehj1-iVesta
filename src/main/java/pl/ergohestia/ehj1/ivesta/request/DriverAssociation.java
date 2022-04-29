package pl.ergohestia.ehj1.ivesta.request;

import java.util.UUID;

public class DriverAssociation {

    private final UUID driverId;

    public DriverAssociation(UUID driverId) {
        this.driverId = driverId;
    }

    public UUID getDriverId() {
        return driverId;
    }
}
