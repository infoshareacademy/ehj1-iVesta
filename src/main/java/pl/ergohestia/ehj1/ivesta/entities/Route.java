package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "routes")

@Getter
@Setter

public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    private String startCity;
    private String startAddress;
    private String destinationCity;
    private String destinationAddress;
    private String driverName;
    private String driverLastName;
    private String assignedVehicle;
    private String cargoType;
    private Integer cargoWeight;
    private Integer routeLength;
}
