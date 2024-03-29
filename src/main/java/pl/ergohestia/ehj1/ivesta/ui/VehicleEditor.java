package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.Service;

import java.io.InputStream;
import java.util.Scanner;

public class VehicleEditor {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleEditor.class);

    private VehicleDto vehicleDto;
    private String userInput;


    public VehicleEditor(VehicleDto vehicleDto) {
        this.vehicleDto = vehicleDto;
    }


    public VehicleDto editVehicle(InputStream in) {

        Scanner scanner = new Scanner(in);
        SYSOUT.info(getMessageForUser("Marka: " + vehicleDto.getBrand()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setBrand(userInput);
        }

        SYSOUT.info(getMessageForUser("Kategoria: " + vehicleDto.getVehicleCategory()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setVehicleCategory(userInput);
        }

        SYSOUT.info(getMessageForUser("Model: " + vehicleDto.getModel()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setModel(userInput);
        }

        SYSOUT.info(getMessageForUser("Typ pojazdu: " + vehicleDto.getVehicleType()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setVehicleType(userInput);
        }

        SYSOUT.info(getMessageForUser("Metoda produkcji: " + vehicleDto.getProductionMethod()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setProductionMethod(userInput);
        }

        SYSOUT.info(getMessageForUser("Rok produkcji: " + vehicleDto.getProductionYear()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setProductionYear(userInput);
        }

        SYSOUT.info(getMessageForUser("Pojemność silnika: " + vehicleDto.getEngineCapacity()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            validateIfInputIsNumber(scanner);
            vehicleDto.setEngineCapacity(Double.parseDouble(userInput));
        }

        SYSOUT.info(getMessageForUser("Moc silnika: " + vehicleDto.getEnginePower()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            validateIfInputIsNumber(scanner);
            vehicleDto.setEnginePower(Double.parseDouble(userInput));
        }

        SYSOUT.info(getMessageForUser("Moc silnika hybrydowego: " + vehicleDto.getHybridEnginePower()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setHybridEnginePower(Double.parseDouble(userInput));
        }

        SYSOUT.info(getMessageForUser("Ilość miejsc: " + vehicleDto.getNumberOfSeats()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            validateIfInputIsNumber(scanner);
            vehicleDto.setNumberOfSeats(Integer.parseInt(userInput));
        }

        SYSOUT.info(getMessageForUser("Rodzaj paliwa: " + vehicleDto.getFuelType()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            vehicleDto.setFuelType(userInput);
        }

        SYSOUT.info(getMessageForUser("Zużycie paliwa: " + vehicleDto.getFuelConsumption()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            validateIfInputIsNumber(scanner);
            vehicleDto.setFuelConsumption(Double.parseDouble(userInput));
        }

        SYSOUT.info(getMessageForUser("Limit wagi: " + vehicleDto.getWeightLimit()));
        userInput = scanner.nextLine();
        if (!userInput.isEmpty()) {
            validateIfInputIsNumber(scanner);
            vehicleDto.setWeightLimit(Double.parseDouble(userInput));
        }

        return vehicleDto;
    }

    private void validateIfInputIsNumber(Scanner scanner) {
        while (!Service.isNumeric(userInput)){
            SYSOUT.warn("Wprowadzono niepoprawne dane: "+userInput+". Podaj w formacie liczby");
            userInput = scanner.nextLine();
        }
    }

    private String getMessageForUser(String input) {
        return ("Kliknij enter lub podaj nową wartość dla parametru: " + input);
    }
}
