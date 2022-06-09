package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.UUID;
@Component
@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
@NoArgsConstructor
@ToString
public class VehicleDto {

    private UUID id;

    @JsonProperty("availability")
    private Availability availability;

    @JsonProperty("marka")
    private String brand;

    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonProperty("license")
    private LicenseType licenseVehicles;

    @JsonProperty("model")
    private String model;

    @JsonProperty("liczba-miejsc-ogolem")
    private int numberOfSeats;

    @JsonProperty("rodzaj-paliwa")
    private String fuelType;

    @JsonProperty("max-ladownosc")
    private double weightLimit;

    public VehicleDto(Availability availability,
                      String brand,
                      LicenseType licenseVehicles,
                      String vehicleCategory,
                      String model,
                      int numberOfSeats,
                      String fuelType,
                      double weightLimit) {
        this.availability = availability;
        this.brand = brand;
        this.licenseVehicles = licenseVehicles;
        this.vehicleCategory = vehicleCategory;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.weightLimit = weightLimit;
    }
}
