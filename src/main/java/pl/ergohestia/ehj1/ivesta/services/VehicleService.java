package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DefaultVehiclePath;
import pl.ergohestia.ehj1.ivesta.Main;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;
import pl.ergohestia.ehj1.ivesta.repository.VehiclesLoader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class VehicleService implements Service<Vehicle>{

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    Scanner scanner = new Scanner(System.in);
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);
    VehiclesLoader vehiclesLoader = new VehiclesLoader(Path.of("src/main/resources/input.json"));
    VehicleValidator vehicleValidator;

    //TODO Create menu for Vehicle Services

    public Path getVehiclePath() {
        return getPath();
    }




    private final List<Vehicle> vehicleList;

    public VehicleService() {
        this.vehicleList = vehiclesLoader.getListOfVehicles();

    }

    public VehicleService(List<Vehicle> vehicleList){
        this.vehicleList = vehicleList;
    }

    public List<Vehicle> getValidVehicles(){
        for (Vehicle vehicle : vehicleList) {
            vehicleValidator = new VehicleValidator(vehicle);
            if (!vehicleValidator.isVehicleValid()){
                log.info(vehicle + "has been removed");
                vehicleList.remove(vehicle);
            }
        }
        return vehicleList;
    }

    public List<Vehicle> getVehiclesList(){
        return vehicleList;
    }

    @Override
    public void printElements() {
        vehicleList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    //TODO implementacja metody
    @Override
    public void addElement(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }

    private Path getPath() {
        try {
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
        } catch (Exception e) {
            SYSOUT.warn("Brak pliku w podanym katalogu! Sprawdź ponownie ścieżkę dostępu.");
        }
        return getVehiclePath();
    }
}
