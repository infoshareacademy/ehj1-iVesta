package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@JsonIgnoreProperties(ignoreUnknown = true)
@Getter
@Setter
public class Vehicle {

    @JsonProperty("marka")
    private String brand;

    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonProperty("model")
    private String model;

    @JsonProperty("rodzaj-pojazdu")
    private String vehicleType;

    @JsonProperty("sposob-produkcji")
    private String productionMethod;

    @JsonProperty("rok-produkcji")
    private String productionYear;

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

    @JsonProperty("dopuszczalna-ladownosc")
    private double weightLimit;


    public Vehicle() {
    }

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
                   double weightLimit)

    {
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