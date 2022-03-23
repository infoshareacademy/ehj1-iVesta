package model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class VehicleAttributes {
    @JsonProperty("kategoria-pojazdu")
    private String vehicleCategory;

    @JsonProperty("model")
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
    private int numberOfSits;

    @JsonProperty("rodzaj-paliwa")
    private String fuelType;

    @JsonProperty("srednie-zuzycie-paliwa")
    private double fuelConsumption;
}
