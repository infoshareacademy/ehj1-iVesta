package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Vehicle {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private VehicleAttributes attributes;

    public Vehicle(Long id, String type, VehicleAttributes attributes) {
        this.id = id;
        this.type = type;
        this.attributes = attributes;
    }
}
