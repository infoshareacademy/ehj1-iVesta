package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.*;

@Slf4j
public class RouteService implements Service<RouteDto> {

    VehicleService vehicleService = new VehicleService();


    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final List<RouteDto> routeList;

    public RouteService() {
        this.routeList = new ArrayList<>();
    }

    public List<RouteDto> getRoutes() {
        return routeList;
    }

    public Integer loadPositiveNumber(Scanner scanner) {
        Integer positiveNumber = 0;
        boolean correctData = false;
        while (positiveNumber <= 0) {
            try {
                positiveNumber = scanner.nextInt();
                if (positiveNumber <= 0) {
                    SYSOUT.info("Podaj liczbę całkowitą dodatnią");
                }
            } catch (InputMismatchException e) {
                SYSOUT.info("Podaj prawidłowe dane (liczba całkowita dodatnia)");
                scanner.next();
            }
        }
        return positiveNumber;
    }

    public String loadTransportType(Scanner scanner) {
        String transportTypeInput = "";
        while (!(transportTypeInput.equals("o") || transportTypeInput.equals("t"))) {
            transportTypeInput = scanner.next();
            if (!(transportTypeInput.equals("o") || transportTypeInput.equals("t"))) {
                System.out.println("Podaj prawidłową literę: o lub t");
            }
        }
        return transportTypeInput;
    }

    public TransportType convertToTransportType(String input) {
        return switch (input) {
            case "o" -> TransportType.PASSENGERS;
            case "t" -> TransportType.CARGO;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }


    public RouteDto addVehicleToRoute(Scanner in, RouteDto routeDto) {
        SYSOUT.info("Wybierz numer samochodu z poniżej listy:");

        List<VehicleDto> vehicles = (List<VehicleDto>) vehicleService.getVehicleDtoList();
        for (int i = 0; i < vehicles.size(); i++) {
            SYSOUT.info((i + 1) + ". " + vehicles.get(i));
        }

        int vehicleNo = getVehicleFromList(in, vehicles.size());
        VehicleDto vehicle = vehicles.get(vehicleNo);
        routeDto.setVehicle(vehicle);
        return routeDto;
    }

    private int getVehicleFromList(Scanner scanner, int vehiclesListSize) {
        int item = 0;
        String incorrecltyInput;
        do {
            SYSOUT.info("Numer samochodu: ");
            if (!scanner.hasNextInt()) {
                incorrecltyInput = scanner.next();
                log.info("User incorrectly wrote " + incorrecltyInput + " when choosing vehicle");
                continue;
            }
            item = scanner.nextInt();
            if (!(item < 1 & item <= vehiclesListSize)) {
                log.info("User incorrectly wrote " + item + " when choosing vehicle");
            }
        } while (!(item >= 1 & item <= vehiclesListSize));

        return item;
    }


    @Override
    public void printElements() {
        routeList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    @Override
    public void addElement(RouteDto routeDto) {
        routeList.add(routeDto);
    }
}