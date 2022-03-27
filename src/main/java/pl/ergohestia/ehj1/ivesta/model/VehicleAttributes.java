package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleAttributes {
    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonProperty("pl/ergohestia/ehj1/ivesta/model")
    private String model;

    @JsonProperty("rodzaj-pojazdu")
    private String vehicleType;

    @JsonProperty("sposob-produkcji")
    private String productionMethod;

    @JsonProperty("rok-produkcji")
    private int productionYear;

    @JsonProperty("pojemnosc-skokowa-silnika")
    private double engineCapacity;

    @JsonProperty("moc-netto-silnika")
    private double enginePower;

    @JsonProperty("moc-netto-silnika-hybrydowego")
    private double hybridEnginePower;

    @JsonProperty("liczba-miejsc-ogole")
    private int numberOfSeats;

    @JsonProperty("rodzaj-paliwa")
    private String fuelType;

    @JsonProperty("srednie-zuzycie-paliwa")
    private double fuelConsumption;

    public VehicleAttributes(String vehicleCategory,
                             String model,
                             String vehicleType,
                             String productionMethod,
                             int productionYear,
                             double engineCapacity,
                             double enginePower,
                             double hybridEnginePower,
                             int numberOfSeats,
                             String fuelType,
                             double fuelConsumption) {
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
    }
}
