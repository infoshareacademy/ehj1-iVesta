package pl.ergohestia.ehj1.ivesta.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RouteDto {

    public Long id;
    private String startAddress;
    private String destinationAddress;
    private Integer routeLength;
    private TransportType transportType;
    private Integer transportVolume;

    public RouteDto(String startAddress,
                    String destinationAddress,
                    Integer routeLength,
                    TransportType transportType,
                    Integer transportVolume) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
    }
}
