package pl.ergohestia.ehj1.ivesta.repository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Route;

import java.io.InputStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RoutesLoader {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

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
                correctData = true;
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba)");
                scanner.next();
            }
        } while (!correctData);

        SYSOUT.info("Podaj rodzaj przewozu (o - osoby, t - towary)");
        String cargoType = "";
        do {
            try {
                cargoType = scanner.nextLine();
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłową literę: o lub t");
                scanner.next();
            }
        } while (!(cargoType.equals("o") || cargoType.equals("t")));

        SYSOUT.info("Podaj ilość osób lub masę towaru w kg");
        Integer cargoWeight = 0;
        correctData = false;
        do {
            try {
                cargoWeight = scanner.nextInt();
                correctData = true;
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba)");
                scanner.next();
            }
        } while (!correctData);

        return new Route(startAddress, destinationAddress, routeLength, cargoType, cargoWeight);
    }

}
