package pl.ergohestia.ehj1.ivesta.repository;

import pl.ergohestia.ehj1.ivesta.model.Route;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RoutesLoader {

    public static final String CSV_DELIMITER = ";";

    private final RouteService routeService = new RouteService();

    public List<Route> getListOfRoutesFromCSV(Path path) {

        List<Route> routes = new ArrayList<>();
        File routesFile = new File(String.valueOf(path));
        try (Scanner scanner = new Scanner(routesFile)) {
            while (scanner.hasNext()) {
                String routesLine = scanner.nextLine();
                String[] routesLineSplitted = routesLine.split(CSV_DELIMITER);
                String startCity = routesLineSplitted[0];
                String startAddress = routesLineSplitted[1];
                String destinationCity = routesLineSplitted[2];
                String destinationAddress = routesLineSplitted[3];
                String driverName = routesLineSplitted[4];
                String driverLastName = routesLineSplitted[5];
                String assignedVehicle = routesLineSplitted[6];
                String cargoType = routesLineSplitted[7];
                Integer cargoWeight = Integer.parseInt(routesLineSplitted[8]);
                Integer routeLength = Integer.parseInt(routesLineSplitted[9]);

                Route route = new Route(startCity, startAddress, destinationCity, destinationAddress, driverName, driverLastName, assignedVehicle, cargoType, cargoWeight, routeLength);
                routeService.addRouteToList(route);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return routeService.getRoutesList();
    }
}
