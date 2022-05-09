package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Availability {
    @JsonProperty("active")
    ACTIVE,

    @JsonProperty("inactive")
    INACTIVE
}
