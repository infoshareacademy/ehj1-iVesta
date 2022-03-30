package pl.ergohestia.ehj1.ivesta.entities;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
public class Vehicle {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private String brand;

    @Column(nullable = false, name = "vehicle_category")
    private String vehicleCategory;

    @Column
    private String model;

    @Column(name = "vehicle_type")
    private String vehicleType;

    @Column(name = "production_method")
    private String productionMethod;

    @Column(name = "production_method")
    private String productionYear;

    @Column(name = "engine_capacity")
    private double engineCapacity;

    @Column(name = "engine_power")
    private double enginePower;

    @Column(name = "hybrid_engine_power")
    private double hybridEnginePower;

    @Column(nullable = false, name = "number_of_seats")
    private int numberOfSeats;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "fuel_consumption")
    private double fuelConsumption;

    @Column(nullable = false, name = "weight_limit")
    private double weightLimit;

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;
}
