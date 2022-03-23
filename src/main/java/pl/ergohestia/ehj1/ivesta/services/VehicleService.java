package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleService implements Service{

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final List<Vehicle> vehicleList;

    public VehicleService() {
        this.vehicleList = new ArrayList<>();
    }

    public List<Vehicle> getVehiclesList(){
        return vehicleList;
    }

    public void addVehicleToList(Vehicle vehicle){
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
}
