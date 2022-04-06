package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class RouteService implements Service<RouteDto> {

    DriverService driverService = new DriverService("path");


    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final List<RouteDto> routeList;

    public RouteService() {
        this.routeList = new ArrayList<>();
    }

    public List<RouteDto> getRoutes() {
        return routeList;
    }

    public Integer loadPositiveNumber(Scanner scanner) {
        Integer positiveNumber = 0;
        boolean correctData = false;
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

    public String loadTransportType(Scanner scanner) {
        String transportTypeInput = "";
        while (!(transportTypeInput.equals("o") || transportTypeInput.equals("t"))) {
            transportTypeInput = scanner.next();
            if (!(transportTypeInput.equals("o") || transportTypeInput.equals("t"))) {
                System.out.println("Podaj prawidłową literę: o lub t");
            }
        }
        return transportTypeInput;
    }

    public TransportType convertToTransportType(String input) {
        return switch (input) {
            case "o" -> TransportType.PASSENGERS;
            case "t" -> TransportType.CARGO;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }


    public DriverDto driverSelect(Scanner scanner) {
        List<DriverDto> driversList = driverService.getDriversList();
        for (int i = 0; i < driversList.size(); i++) {
            SYSOUT.info((i + 1) + ". " + driversList.get(i));
        }

        int driverNo = getDriverFromList(scanner, driversList.size());
        return driversList.get(driverNo);
    }

    private int getDriverFromList(Scanner scanner, int driversListSize) {
        int item = 0;
        String incorrecltyInput;
        do {
            SYSOUT.info("Numer kierowcy: ");
            if (!scanner.hasNextInt()) {
                incorrecltyInput = scanner.next();
                log.info("User incorrectly wrote " + incorrecltyInput + " when choosing driver");
                continue;
            }
            item = scanner.nextInt();
            if (!(item < 1 & item <= driversListSize)) {
                log.info("User incorrectly wrote " + item + " when choosing driver");
            }
        } while (!(item >= 1 & item <= driversListSize));

        return item;
    }


    @Override
    public void printElements() {
        routeList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    @Override
    public void addElement(RouteDto routeDto) {
        routeList.add(routeDto);
    }
}