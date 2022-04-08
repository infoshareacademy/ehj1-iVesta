package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;

import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RouteDto {

    public UUID id;
    private String startAddress;
    private String destinationAddress;
    private Integer routeLength;
    private TransportType transportType;
    private Integer transportVolume;
    private VehicleDto vehicle;
    private DriverDto driver;

    public RouteDto(String startAddress,
                    String destinationAddress,
                    Integer routeLength,
                    TransportType transportType,
                    Integer transportVolume) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
    }
}
