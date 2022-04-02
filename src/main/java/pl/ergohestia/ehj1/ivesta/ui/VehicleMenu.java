package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

import java.util.List;
import java.util.Scanner;

public class VehicleMenu {

    private static final Logger log = LoggerFactory.getLogger(MenuService.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    VehicleService vehicleService = new VehicleService();

    public void runVehicleMenu(){
        printMenu(vehicleMenu.menuItems);
        serviceVehicleMenu();
    }

    private final Menu vehicleMenu = new Menu(
            "1. Wyświetl wszystkie pojazdy.",
            "2. Wyświetl wszystkie dostępne pojazdy.",
            "3. Załaduj nowe pojazdy");

    private void subVehicleMenuNo1() {
        logSubMenu(1);
        vehicleService.getVehicleDtoList();
    }

    private void subVehicleMenuNo2() {
        logSubMenu(2);
    }

    private void subVehicleMenuNo3() {
        logSubMenu(3);
        vehicleService.LoadVehicle();
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = vehicleMenu.menuItems.get(menuIndex);
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
        Scanner scanner = new Scanner(System.in);
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
