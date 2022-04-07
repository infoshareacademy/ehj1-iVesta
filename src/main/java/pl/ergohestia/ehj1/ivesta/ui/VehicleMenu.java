package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.vehicle.VehicleService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class VehicleMenu {

    private Logger log = LoggerFactory.getLogger(MenuService.class);
    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    VehicleService vehicleService = new VehicleService();

    public void runVehicleMenu(){
        printMenu(vehicleMenu.getMenuItems());
        serviceVehicleMenu();
    }

    private final Menu vehicleMenu = new Menu(
            "1. Wyświetl wszystkie pojazdy.",
            "2. Wyświetl wszystkie dostępne pojazdy.",
            "3. Załaduj nowe pojazdy",
            "4. Edycja danych pojazdu");

    private void printVehicles() {
        logSubMenu(1);
        Collection<VehicleDto> vehicles = vehicleService.getVehicleDtoList();
        for (VehicleDto vehicle : vehicles) {
            SYSOUT.info(String.valueOf(vehicle));
        }
    }

    private void printAvailableVehicles(
            //TODO implementacja dla wyświetlania pojazdów bez kierowcy
    ) {
        logSubMenu(2);
    }

    private void loadNewVehicles() {
        logSubMenu(3);
        vehicleService.LoadVehicle();
    }

    private void editVehicles() {
        logSubMenu(4);
        vehicleService.LoadVehicle();
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = vehicleMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    private void serviceVehicleMenu() {
        int item;
        while (true) {
            item = getMenuItem();
            switch (item) {
                case 1 -> printVehicles();
                case 2 -> printAvailableVehicles();
                case 3 -> loadNewVehicles();
                default -> {
                    log.info("User incorrectly wrote " + item + " in menu");
                    continue;
                }
            }
            break;
        }
    }

    private int getMenuItem() {
        Scanner scanner = in.getScanner();
        int item = 0;
        String incorrecltyInput;
        do {
            SYSOUT.info("Wybierz numer z menu: ");
            if (!scanner.hasNextInt()) {
                incorrecltyInput = scanner.next();
                log.info("User incorrectly wrote " + incorrecltyInput + " in menu");
                continue;
            }
            item = scanner.nextInt();
            if (item < 1) {
                log.info("User incorrectly wrote " + item + " in menu");
            }
        } while (item < 1);
        return item;
    }

    private void printMenu(List<String> menuItems) {
        for (String item : menuItems) {
            SYSOUT.info(item);
        }
    }
}
