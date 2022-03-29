package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Route {

    private String startAddress;
    private String destinationAddress;
    private Integer routeLength;
    private String cargoType;
    private Integer cargoWeight;

    public Route(String startAddress, String destinationAddress, Integer routeLength, String cargoType, Integer cargoWeight) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
    }

    public Route() {
    }
}
