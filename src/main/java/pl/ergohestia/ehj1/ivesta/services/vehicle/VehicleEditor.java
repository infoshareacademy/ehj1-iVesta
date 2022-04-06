package pl.ergohestia.ehj1.ivesta.services.vehicle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.Scanner;

public class VehicleEditor {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleEditor.class);

    private VehicleDto vehicleDto;
    private String userInput;

    Scanner scanner = new Scanner(System.in);

    public VehicleEditor(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
    }


    public VehicleDto editVehicle() {

        SYSOUT.info(getMessageForUser(vehicleDto.getBrand()));
        userInput = scanner.nextLine();
        if (userInput != null){
            vehicleDto.setBrand(userInput);
        }

        SYSOUT.info(getMessageForUser(vehicleDto.getVehicleCategory()));
        userInput = scanner.nextLine();
        if (userInput != null){
            vehicleDto.setVehicleCategory(userInput);
        }

        String model;

        String vehicleType;

        String productionMethod;

        String productionYear;

        double engineCapacity;

        double enginePower;

        double hybridEnginePower;

        int numberOfSeats;

        String fuelType;

        double fuelConsumption;

        double weightLimit;

        return vehicleDto;
    }

    private String getMessageForUser(String input){
        return ("Kliknij enter lub podaj nową wartość dla parametru: " + input);
    }
}
