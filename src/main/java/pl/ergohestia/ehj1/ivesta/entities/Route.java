package pl.ergohestia.ehj1.ivesta.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "routes")
@Getter
@Setter
@NoArgsConstructor
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

    private LocalDate date;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "driver_id")
    private Driver driver;

    public Route(String startAddress, String destinationAddress, Integer routeLength, TransportType transportType, Integer transportVolume, LocalDate date) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Route{" +
                "id=" + id +
                ", startAddress='" + startAddress + '\'' +
                ", destinationAddress='" + destinationAddress + '\'' +
                ", routeLength=" + routeLength +
                ", transportType=" + transportType +
                ", transportVolume=" + transportVolume +
                ", date=" + date +
                ", vehicle=" + vehicle +
                ", driver=" + driver +
                '}';
    }
}