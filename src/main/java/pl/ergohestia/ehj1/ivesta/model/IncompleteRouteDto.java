package pl.ergohestia.ehj1.ivesta.model;

import java.time.LocalDate;

public record IncompleteRouteDto(
        String startAddress,
        String destinationAddress,
        Integer routeLength,
        TransportType transportType,
        Integer transportVolume,
        LocalDate date,
        String vehicleId,
        String driverId) {
}
