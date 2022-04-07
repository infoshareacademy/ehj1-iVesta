package pl.ergohestia.ehj1.ivesta.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import javax.persistence.*;
import java.util.UUID;

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
    @GeneratedValue(generator = "uuid-generator")
    @GenericGenerator(name = "uuid-generator", strategy = "uuid2")
    @Type(type = "uuid-char")
    @Column(length = 36, updatable = false, nullable = false)
    private UUID id;

    @Column(name = "start_address", nullable = false)
    private String startAddress;

    @Column(name = "destination_address", nullable = false)
    private String destinationAddress;

    @Column(name = "route_length")
    private Integer routeLength;

    @Column(name = "transport_type")
    @Enumerated(EnumType.STRING)
    private TransportType transportType;

    @Column(name = "transport_volume")
    private Integer transportVolume;

    public Route(String startAddress, String destinationAddress, Integer routeLength, TransportType transportType, Integer transportVolume) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
    }
}