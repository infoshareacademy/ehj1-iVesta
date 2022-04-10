package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.RouteService;
import pl.ergohestia.ehj1.ivesta.services.vehicle.VehicleService;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class RoutesLoader {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    VehicleService vehicleService;
    RouteService routeService;

    public RoutesLoader init() {
        vehicleService = new VehicleService();
        routeService = new RouteService();
        return this;
    }

    public RouteDto loadRoute(InputStream in) {
        Scanner scanner = new Scanner(in);

        SYSOUT.info("Podaj adres początkowy");
        String startAddress = scanner.nextLine();

        SYSOUT.info("Podaj adres końcowy");
        String destinationAddress = scanner.nextLine();

        SYSOUT.info("Podaj długość trasy");
        Integer routeLength = loadPositiveNumber(scanner);

        SYSOUT.info("Podaj rodzaj przewozu (o - osoby, t - towary)");
        TransportType transportTypeInput = loadTransportType(scanner);

        SYSOUT.info("Podaj ilość osób lub masę towaru w kg");
        Integer transportVolume = loadPositiveNumber(scanner);

        SYSOUT.info("Podaj datę transportu w formacie dd/mm/rrrr:");
        LocalDate date = loadCorrectDate(scanner);

        return new RouteDto(startAddress, destinationAddress, routeLength, transportTypeInput, transportVolume, date);
    }

    TransportType loadTransportType(Scanner scanner) {
        String transportTypeInput = "";
        while (!(transportTypeInput.equalsIgnoreCase("o") || transportTypeInput.equalsIgnoreCase("t"))) {
            transportTypeInput = scanner.next();
            if (!(transportTypeInput.equalsIgnoreCase("o") || transportTypeInput.equalsIgnoreCase("t"))) {
                SYSOUT.info("Podaj prawidłową literę: o lub t");
            }
        }
        return routeService.convertToTransportType(transportTypeInput);
    }

    public Integer loadPositiveNumber(Scanner scanner) {
        Integer positiveNumber = 0;
        while (positiveNumber <= 0) {
            try {
                positiveNumber = scanner.nextInt();
                if (positiveNumber <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
            }
        }
        return positiveNumber;
    }

    private LocalDate loadCorrectDate(Scanner scanner) {
        scanner = new Scanner(System.in);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        boolean isCorrect = false;
        LocalDate correctDate = null;
        while (!isCorrect) {
            try {
                correctDate = LocalDate.parse(scanner.nextLine(), formatter);
                isCorrect = true;
            } catch (Exception e) {
                SYSOUT.info("Podaj prawidłowy format daty.");
            }
        }
        return correctDate;
    }

    public RouteDto addVehicleToRoute(Scanner in, RouteDto routeDto) {
        List<VehicleDto> vehicles = (List<VehicleDto>) vehicleService.getVehicleDtoList();
        if (vehicles.isEmpty()) {
            return routeDto;
        } else {
            SYSOUT.info("Wybierz numer samochodu z poniższej listy:");
            for (int i = 0; i < vehicles.size(); i++) {
                SYSOUT.info("{}. {}", (i + 1), vehicles.get(i));
            }

            int vehicleNo = getVehicleFromList(in, vehicles.size()) - 1;
            VehicleDto vehicle = vehicles.get(vehicleNo);
            routeDto.setVehicle(vehicle);
            return routeDto;
        }
    }

    private int getVehicleFromList(Scanner scanner, int vehiclesListSize) {
        int item = 0;
        String incorrecltyInput;
        do {
            SYSOUT.info("Numer samochodu: ");
            if (!scanner.hasNextInt()) {
                incorrecltyInput = scanner.next();
                log.info("User incorrectly wrote {} when choosing vehicle", incorrecltyInput);
                continue;
            }
            item = scanner.nextInt();
            if (!(item < 1 & item <= vehiclesListSize)) {
                log.info("User incorrectly wrote {} when choosing vehicle", item);
            }
        } while (!(item >= 1 & item <= vehiclesListSize));

        return item;
    }

}
