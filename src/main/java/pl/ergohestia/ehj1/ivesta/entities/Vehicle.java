package pl.ergohestia.ehj1.ivesta.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "vehicle.findAll", query = "from Vehicle")
})
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

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

    @Column(name = "production_year")
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

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Route> route;

    @OneToOne(mappedBy = "vehicle")
    private Driver driver;

    public Vehicle(String brand,
                   String vehicleCategory,
                   String model,
                   String vehicleType,
                   String productionMethod,
                   String productionYear,
                   double engineCapacity,
                   double enginePower,
                   double hybridEnginePower,
                   int numberOfSeats,
                   String fuelType,
                   double fuelConsumption,
                   double weightLimit) {
        this.brand = brand;
        this.vehicleCategory = vehicleCategory;
        this.model = model;
        this.vehicleType = vehicleType;
        this.productionMethod = productionMethod;
        this.productionYear = productionYear;
        this.engineCapacity = engineCapacity;
        this.enginePower = enginePower;
        this.hybridEnginePower = hybridEnginePower;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.fuelConsumption = fuelConsumption;
        this.weightLimit = weightLimit;
    }
}
