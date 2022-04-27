package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.UUID;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VehicleDto {

    private UUID id;

    @JsonProperty("marka")
    private String brand;

    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonProperty("model")
    private String model;

    @JsonProperty("liczba-miejsc-ogolem")
    private int numberOfSeats;

    @JsonProperty("rodzaj-paliwa")
    private String fuelType;

    @JsonProperty("max-ladownosc")
    private double weightLimit;

    public VehicleDto(UUID id,
                      String brand,
                      String vehicleCategory,
                      String model,
                      int numberOfSeats,
                      String fuelType,
                      double weightLimit) {
        this.id = id;
        this.brand = brand;
        this.vehicleCategory = vehicleCategory;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.weightLimit = weightLimit;
    }
}
