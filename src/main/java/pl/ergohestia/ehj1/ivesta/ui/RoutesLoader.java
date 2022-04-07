package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.io.InputStream;
import java.time.LocalDate;
import java.util.InputMismatchException;
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
        Integer routeLength = loadPositiveNumber(scanner);

        SYSOUT.info("Podaj rodzaj przewozu (o - osoby, t - towary)");
        TransportType transportTypeInput = loadTransportType(scanner);

        SYSOUT.info("Podaj ilość osób lub masę towaru w kg");
        Integer transportVolume = loadPositiveNumber(scanner);

        SYSOUT.info("Podaj datę transportu w formacie rrrr-mm-dd:");
        String date = scanner.nextLine();

        return new RouteDto(startAddress, destinationAddress, routeLength, transportTypeInput, transportVolume, LocalDate.parse(date));
    }

    private TransportType loadTransportType(Scanner scanner) {
        String transportTypeInput = "";
        while(!(transportTypeInput.equalsIgnoreCase("o") || transportTypeInput.equalsIgnoreCase("t"))) {
            transportTypeInput = scanner.next();
            if (!(transportTypeInput.equalsIgnoreCase("o") || transportTypeInput.equalsIgnoreCase("t"))) {
                SYSOUT.info("Podaj prawidłową literę: o lub t");
            }
        }
        return routeService.convertToTransportType(transportTypeInput);
    }

    public Integer loadPositiveNumber(Scanner scanner) {
        Integer positiveNumber = 0;
        while (positiveNumber <= 0) {
            try {
                positiveNumber = scanner.nextInt();
                if (positiveNumber <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
                scanner.next();
            }
        }
        return positiveNumber;
    }
    //TODO implements method
//    private LocalDate loadCorrectData(String input) {
//    }

}
