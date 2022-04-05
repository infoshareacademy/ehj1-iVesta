package pl.ergohestia.ehj1.ivesta.services.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;

public class VehicleEditor {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private Vehicle vehicle;


    public VehicleEditor(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public int getOptionnumberFromUser(){
        int number = 0;
        SYSOUT.info("Podaj numer parametru, który ma zostać poprawiony:");
        return number;
    }

}
