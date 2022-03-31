package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Route;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RouteService implements Service<Route> {

    // TODO remove
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final List<Route> routeList;

    public RouteService() {
        this.routeList = new ArrayList<>();
    }

    public List<Route> getRoutesList() {
        return routeList;
    }

    public void addRouteToList(Route route) {
        routeList.add(route);
    }

    public Integer positiveIntegerValidator(Scanner scanner) {
        Integer positiveInteger = 0;
        boolean correctData = false;
        do {
            try {
                positiveInteger = scanner.nextInt();
                if (positiveInteger <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                } else {
                    correctData = true;
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
                scanner.next();
            }
        } while (!correctData);
        return positiveInteger;
    }


    public TransportType convertToTransportType(String input) {
        return switch(input) {
            case "o" -> TransportType.PASSENGERS;
            case "t" -> TransportType.CARGO;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    @Override
    public void printElements() {
        routeList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    //TODO implementacja metody

    @Override
    public void addElement(Route route) {
    }
}