package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Route {

    private String startCity;
    private String startAddress;
    private String destinationCity;
    private String destinationAddress;
    private String driverName;
    private String driverLastName;
    private String cargoType;
    private Integer cargoWeight;
    private Integer routeLength;

    public Route(String startCity, String startAddress, String destinationCity, String destinationAddress, String driverName, String driverLastName, String cargoType, Integer cargoWeight, Integer routeLength) {
        this.startCity = startCity;
        this.startAddress = startAddress;
        this.destinationCity = destinationCity;
        this.destinationAddress = destinationAddress;
        this.driverName = driverName;
        this.driverLastName = driverLastName;
        this.cargoType = cargoType;
        this.cargoWeight = cargoWeight;
        this.routeLength = routeLength;
    }
}
