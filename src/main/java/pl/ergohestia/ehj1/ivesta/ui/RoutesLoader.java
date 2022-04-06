package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.io.InputStream;
import java.util.Scanner;

public class RoutesLoader {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    RouteService routeService = new RouteService();

    public RouteDto loadRoute(InputStream in) {
        Scanner scanner = new Scanner(in);

        SYSOUT.info("Podaj adres początkowy");
        String startAddress = scanner.nextLine();

        SYSOUT.info("Podaj adres końcowy");
        String destinationAddress = scanner.nextLine();

        SYSOUT.info("Podaj długość trasy");
        Integer routeLength = routeService.loadPositiveNumber(scanner);

        SYSOUT.info("Podaj rodzaj przewozu (o - osoby, t - towary)");
        String transportTypeInput = routeService.loadTransportType(scanner);

        SYSOUT.info("Podaj ilość osób lub masę towaru w kg");
        Integer transportVolume = routeService.loadPositiveNumber(scanner);


        return new RouteDto(startAddress, destinationAddress, routeLength, routeService.convertToTransportType(transportTypeInput), transportVolume);
    }

}
