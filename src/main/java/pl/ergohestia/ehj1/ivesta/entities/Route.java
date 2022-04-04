package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@ToString
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    private Long id;

    @Column(name = "start_address",nullable = false)
    private String startAddress;

    @Column(name = "destination_address",nullable = false)
    private String destinationAddress;

    @Column(name = "route_length")
    private Integer routeLength;

    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Column(name = "transport_volume")
    private Integer transportVolume;
}