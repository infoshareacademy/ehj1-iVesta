package pl.ergohestia.ehj1.ivesta.controller.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.UUID;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RouteRequest {

    public UUID id;
    @NotNull
    private String startAddress;
    @NotNull
    private String destinationAddress;
    @NotNull
    @Min(1)
    private Integer routeLength;
    @NotNull
    private TransportType transportType;
    @NotNull
    @Min(1)
    private Integer transportVolume;
    @NotNull
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate date;
    private VehicleDto vehicle;
    private DriverDto driver;

    public RouteRequest(String startAddress,
                        String destinationAddress,
                        Integer routeLength,
                        TransportType transportType,
                        Integer transportVolume,
                        LocalDate date) {
        this.startAddress = startAddress;
        this.destinationAddress = destinationAddress;
        this.routeLength = routeLength;
        this.transportType = transportType;
        this.transportVolume = transportVolume;
        this.date = date;
    }

    public RouteRequest(String startAddress, String destinationAddress, Integer routeLength, TransportType transportType, Integer transportVolume) {
    }
}
