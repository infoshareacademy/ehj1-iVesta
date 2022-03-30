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

    @Column(name = "start_city",nullable = false)
    private String startCity;

    @Column(name = "start_address",nullable = false)
    private String startAddress;

    @Column(name = "destination_city",nullable = false)
    private String destinationCity;

    @Column(name = "destination_address",nullable = false)
    private String destinationAddress;

    @Column(name = "driver_name")
    private String driverName;

    @Column(name = "driver_last_name")
    private String driverLastName;

    @Column(name = "assigned_vehicle")
    private String assignedVehicle;

    @Column(name = "cargo_type")
    private String cargoType;

    @Column(name = "cargo_weight")
    private Integer cargoWeight;

    @Column(name = "route_length")
    private Integer routeLength;
}
