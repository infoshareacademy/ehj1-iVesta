package pl.ergohestia.ehj1.ivesta.request;

import java.util.UUID;

public record DriverAssociation(UUID driverId) {
    public UUID getDriverId() {
        return driverId;
    }
}
