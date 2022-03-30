package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Route {

    private String startAddress;
    private String destinationAddress;
    private Integer routeLength;
    private TransportType transportType;
    private Integer transportVolume;

    public Route(String startAddress, String destinationAddress, Integer routeLength, TransportType transportType, Integer transportVolume) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
    }

    public Route() {
    }
}
