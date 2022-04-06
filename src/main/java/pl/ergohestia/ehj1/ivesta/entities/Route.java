package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import javax.persistence.*;

@Entity
@Table(name = "routes")
@Getter
@Setter
@ToString
@NoArgsConstructor
@NamedQueries({
        @NamedQuery(name = "route.findAll", query = "from Route")
})
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

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Route(String startAddress, String destinationAddress, Integer routeLength, TransportType transportType, Integer transportVolume) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
    }
}