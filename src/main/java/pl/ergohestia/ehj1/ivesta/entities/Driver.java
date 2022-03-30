package pl.ergohestia.ehj1.ivesta.entities;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "drivers")

@Getter
@Setter

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



