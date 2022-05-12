package pl.ergohestia.ehj1.ivesta.entities;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.ergohestia.ehj1.ivesta.model.Availability;

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

    @Column(name ="vehicle_status")
    @Enumerated(EnumType.STRING)
    @JsonProperty("availability")
    private Availability availability = Availability.ACTIVE;

    @Column
    @JsonProperty("marka")
    private String brand;

    @Column(name = "vehicle_category")
    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @Column
    private String model;

    @Column(nullable = false, name = "number_of_seats")
    @JsonProperty("liczba-miejsc-ogolem")
    @Min(value = 1)
    private int numberOfSeats;

    @Column(name = "fuel_type")
    @JsonProperty("rodzaj-paliwa")
    private String fuelType;

    @Column(nullable = false, name = "weight_limit")
    @JsonProperty("max-ladownosc")
    @Min(0)
    private double weightLimit;


    @OneToMany(mappedBy = "vehicle", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Route> route;

    public Vehicle(Availability availability,
                   String brand,
                   String vehicleCategory,
                   String model,
                   int numberOfSeats,
                   String fuelType,
                   double weightLimit) {
        this.availability = availability;
        this.brand = brand;
        this.vehicleCategory = vehicleCategory;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.weightLimit = weightLimit;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", availability=" + availability +
                ", brand='" + brand + '\'' +
                ", vehicleCategory='" + vehicleCategory + '\'' +
                ", model='" + model + '\'' +
                ", numberOfSeats=" + numberOfSeats +
                ", fuelType='" + fuelType + '\'' +
                ", weightLimit=" + weightLimit +
                ", route=" + route +
                '}';
    }
}
