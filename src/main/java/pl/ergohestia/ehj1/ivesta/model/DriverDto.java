package pl.ergohestia.ehj1.ivesta.model;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DriverDto {
    private UUID id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String license;
    private Boolean active;
    private Integer numberOfCourses;
    private Integer numberOfKilometres;

    public DriverDto(String name,
                     String lastName,
                     String address,
                     String phoneNumber,
                     String license,
                     Boolean active,
                     Integer numberOfCourses,
                     Integer numberOfKilometres) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.license = license;
        this.active = active;
        this.numberOfCourses = numberOfCourses;
        this.numberOfKilometres = numberOfKilometres;
    }
}
