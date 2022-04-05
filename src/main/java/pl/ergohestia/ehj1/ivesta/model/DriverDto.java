package pl.ergohestia.ehj1.ivesta.model;

import com.sun.xml.bind.v2.model.core.ID;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class DriverDto {
    private UUID id;
    private String name;
    private String lastName;
    private String address;
    private String phoneNumber;
    private String license;
    private Integer numberOfCourses;
    private Integer numberOfKilometres;

    public DriverDto(String name,
                     String lastName,
                     String address,
                     String phoneNumber,
                     String license,
                     Integer numberOfCourses,
                     Integer numberOfKilometres) {
        this.name = name;
        this.lastName = lastName;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.license = license;
        this.numberOfCourses = numberOfCourses;
        this.numberOfKilometres = numberOfKilometres;
    }
}
