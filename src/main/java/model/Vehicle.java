package model;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Vehicle {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("type")
    private String type;

    @JsonProperty("attributes")
    private VehicleAttributes attributes;
}
