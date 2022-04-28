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
    private String phoneNumber;
    private String license;

    public DriverDto(String name,
                     String lastName,
                     String phoneNumber,
                     String license) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.license = license;
    }
}
