package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Route;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoutesLoader {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    RouteService routeService = new RouteService();

    public Route loadRoute(InputStream in) {
        Scanner scanner = new Scanner(in);

        SYSOUT.info("Podaj adres początkowy");
        String startAddress = scanner.nextLine();

        SYSOUT.info("Podaj adres końcowy");
        String destinationAddress = scanner.nextLine();

        SYSOUT.info("Podaj długość trasy");
        Integer routeLength = 0;
        boolean correctData = false;
        do {
            try {
                routeLength = scanner.nextInt();
                if (routeLength <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                } else {
                    correctData = true;
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
                scanner.next();
            }
        } while (!correctData);

        SYSOUT.info("Podaj rodzaj przewozu (o - osoby, t - towary)");
        String transportTypeInput = "";
        do {
            transportTypeInput = scanner.next();
            if (transportTypeInput.equals("o") && transportTypeInput.equals("t")) {
                System.out.println("Podaj prawidłową literę: o lub t");
            } else {
                correctData = true;
            }
        }
        while (!correctData);

        SYSOUT.info("Podaj ilość osób lub masę towaru w kg");
        Integer transportVolume = 0;
        correctData = false;
        do {
            try {
                transportVolume = scanner.nextInt();
                if (transportVolume <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                } else {
                    correctData = true;
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
                scanner.next();
            }
        } while (!correctData);

        return new Route(startAddress, destinationAddress, routeLength, routeService.convertToTransportType(transportTypeInput), transportVolume);
    }

}
