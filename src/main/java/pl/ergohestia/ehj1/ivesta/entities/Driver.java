package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.ergohestia.ehj1.ivesta.converters.LicenseHibernateConverter;
import pl.ergohestia.ehj1.ivesta.model.Availability;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@ToString
@NoArgsConstructor
public class Driver {

    @Id
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false, name = "last_name")
    private String lastName;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    @Convert(converter = LicenseHibernateConverter.class)
    private LicenseType license;

    @Column
    private Availability availability;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    private List<Route> route;

    public Driver(String name,
                  String lastName,
                  String phoneNumber,
                  LicenseType license,
                  Availability availability) {
        this.name = name;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.license = license;
        this.availability = availability;
    }
}