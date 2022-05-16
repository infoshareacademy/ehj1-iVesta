package pl.ergohestia.ehj1.ivesta.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum LicenseType {
    AM,
    A1,
    A2,
    A,
    B,
    B1,

    @JsonProperty("B+E")
    B_E,
    C,
    C1,

    @JsonProperty("C1+E")
    C1_E,

    @JsonProperty("C+E")
    C_E,
    D,
    D1,

    @JsonProperty("D1+E")
    D1_E,

    @JsonProperty("D+E")
    D_E,
    T
}
