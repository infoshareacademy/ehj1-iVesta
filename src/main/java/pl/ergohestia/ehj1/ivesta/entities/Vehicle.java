package pl.ergohestia.ehj1.ivesta.entities;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.ergohestia.ehj1.ivesta.converters.LicenseHibernateConverter;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;

import javax.persistence.*;
import javax.validation.constraints.Min;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "vehicles")
@Getter
@Setter
@NoArgsConstructor
public class Vehicle {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    @Column
    private String brand;

    @Column
    @Convert(converter = LicenseHibernateConverter.class)
    private LicenseType license;

    @Column
    private String model;

    @Column(nullable = false, name = "number_of_seats")
    @Min(value = 1)
    private int numberOfSeats;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(nullable = false, name = "weight_limit")
    @Min(0)
    private double weightLimit;

    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Route> route;

    public Vehicle(String brand,
                   LicenseType vehicleLicense,
                   String model,
                   int numberOfSeats,
                   String fuelType,
                   double weightLimit) {
        this.brand = brand;
        this.license = vehicleLicense;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.weightLimit = weightLimit;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", vehicleCategory='" + license + '\'' +
                ", model='" + model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", fuelType='" + fuelType + '\'' +
                ", weightLimit=" + weightLimit +
                ", route=" + route +
                '}';
    }
}
