package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DefaultVehiclePath;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleService implements Service {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    Scanner scanner = new Scanner(System.in);

    //TODO Create menu for Vehicle Services

    public Path getVehiclePath() {
        return getPath();
    }

    private final List<Vehicle> vehicleList;

    public VehicleService() {
        this.vehicleList = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesList() {
        return vehicleList;
    }

    public void addVehicleToList(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    //TODO implementacja metody
    @Override
    public void printElements() {
        vehicleList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    //TODO implementacja metody
    @Override
    public void addElement() {
    }
    private Path getPath() {
        SYSOUT.info("Czy pliki dotyczące pojazdu mają byc wczytane z domyślen ścieżki? \n T\\N");
        String answer = scanner.nextLine();
        if (answer.equalsIgnoreCase("t")) {
            DefaultVehiclePath defaultPath = new DefaultVehiclePath();
            return defaultPath.vehiclePath;
        } else if (answer.equalsIgnoreCase("n")) {
            SYSOUT.info("Proszę o podanie pełnej ścieżki z lokalizacją pliku: ");
            answer = scanner.nextLine();
            DefaultVehiclePath defaultPath = new DefaultVehiclePath(answer);
            return defaultPath.vehiclePath;
        }
        return getVehiclePath();
    }
}
