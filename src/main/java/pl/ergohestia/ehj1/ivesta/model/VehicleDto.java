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

    private String brand;

    private LicenseType license;

    private String model;

    private int numberOfSeats;

    private String fuelType;

    private double weightLimit;

    public VehicleDto(
            String brand,
            LicenseType license,
            String model,
            int numberOfSeats,
            String fuelType,
            double weightLimit) {
        this.brand = brand;
        this.license = license;
        this.model = model;
        this.numberOfSeats = numberOfSeats;
        this.fuelType = fuelType;
        this.weightLimit = weightLimit;
    }
}
