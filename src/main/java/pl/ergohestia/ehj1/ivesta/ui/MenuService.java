package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.RouteService;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private static final Logger log = LoggerFactory.getLogger(MenuService.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    VehicleService vehicleService = new VehicleService();
    DriverService driverService = new DriverService("path");
    RouteService routeService = new RouteService();

    private final Menu mainMenu = new Menu(
            "1. Wyświetl kierowców.",
            "2. Wyświetl samochody.",
            "3. Zaplanuj trasę.");

    private void subMenuNo1() {
        logSubMenu(1);
    }

    private void subMenuNo2() {
        logSubMenu(2);
    }

    private void subMenuNo3() {
        logSubMenu(3);
        // UI route serivce - wczyta dane, zwróci RouteDto (Arek)
        // route serivce - dodaje drivera i auto (Michał)
        // wypisanie wyniku (Michał)
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = mainMenu.menuItems.get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    public void menu() {
        printMenu(mainMenu.menuItems);
        serviceMainMenu();
    }

    private void serviceMainMenu() {
        int item;
        while (true) {
            item = getMenuItem();
            switch (item) {
                case 1 -> subMenuNo1();
                case 2 -> subMenuNo2();
                case 3 -> subMenuNo3();
                default -> {
                    log.info("User incorrectly wrote " + item + " in menu");
                    continue;
                }
            }
            break;
        }
    }

    private void printMenu(List<String> menuItems) {
        for (String item : menuItems) {
            SYSOUT.info(item);
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

}
