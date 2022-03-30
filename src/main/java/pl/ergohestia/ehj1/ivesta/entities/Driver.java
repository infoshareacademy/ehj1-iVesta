package pl.ergohestia.ehj1.ivesta.entities;
import javax.persistence.*;

@Entity
@Table(name = "drivers")


public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String lastName;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String license;

    @Column
    private Integer numberOfCourses;

    @Column
    private Integer numberOfKilometres;
}



