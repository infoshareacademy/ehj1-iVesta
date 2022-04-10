package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "drivers.findAll", query = "from Driver"),
        @NamedQuery(name = "drivers.findAvailable", query = "FROM Driver d WHERE d.id NOT IN (SELECT DISTINCT r.driver.id FROM Route r)")
})

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

    @Column
    private String address;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column
    private String license;

    @Column(name = "number_of_courses")
    private Integer numberOfCourses;

    @Column(name = "number_of_kilometres")
    private Integer numberOfKilometres;

    @OneToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    private List<Route> route;

    public Driver(String name,
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