package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class VehicleMenu {

    private Logger log = LoggerFactory.getLogger(VehicleMenu.class);
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
            "3. Załaduj nowe pojazdy");

    private void subVehicleMenuNo1() {
        logSubMenu(1);
        Collection<Vehicle> vehicles = vehicleService.getVehicleDtoList();
        for (Vehicle vehicle : vehicles) {
            SYSOUT.info(String.valueOf(vehicle));
        }
    }

    private void subVehicleMenuNo2(
            //TODO implementacja dla wyświetlania pojazdów bez kierowcy
    ) {
        logSubMenu(2);
    }

    private void subVehicleMenuNo3() {
        logSubMenu(3);
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
                case 1 -> subVehicleMenuNo1();
                case 2 -> subVehicleMenuNo2();
                case 3 -> subVehicleMenuNo3();
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
