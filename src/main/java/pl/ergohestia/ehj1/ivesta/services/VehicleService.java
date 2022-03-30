package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.Main;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;
import pl.ergohestia.ehj1.ivesta.repository.VehiclesLoader;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class VehicleService implements Service<Vehicle>{

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger log = LoggerFactory.getLogger(VehicleService.class);

    VehiclesLoader vehiclesLoader = new VehiclesLoader(Path.of("src/main/resources/input.json"));

    VehicleValidator vehicleValidator;


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

    @Override
    public void addElement(Vehicle vehicle) {
        vehicleList.add(vehicle);
    }


}
