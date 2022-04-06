package pl.ergohestia.ehj1.ivesta.entities;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "drivers")
@Getter
@Setter
@ToString
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

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

    @Column(name = "number_of_columns")
    private Integer numberOfCourses;

    @Column(name = "number_of_kilometres")
    private Integer numberOfKilometres;

    @OneToMany(mappedBy = "driver", fetch = FetchType.LAZY)
    @OrderColumn
    private List<Route> owners;
}