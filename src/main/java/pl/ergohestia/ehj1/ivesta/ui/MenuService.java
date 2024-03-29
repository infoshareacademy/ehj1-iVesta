package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private Logger log = LoggerFactory.getLogger(MenuService.class);
    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    DriverService driverService;
    RoutesMenu routesMenu;
    RouteService routeService;
    VehicleMenu vehicleMenu;
    RoutesLoader routesLoader;
    DriverMenu driverMenu;

    public MenuService init() {
        driverService = new DriverService();
        routeService = new RouteService();
        routesMenu = new RoutesMenu();
        vehicleMenu = new VehicleMenu();
        routesLoader = new RoutesLoader().init();
        driverMenu = new DriverMenu();
        return this;
    }

    private Menu mainMenu = new Menu(
            "1. Obsługa kierowców.",
            "2. Obsługa pojazdów.",
            "3. Obsługa tras.",
            "4. Wyjdź z aplikacji.");

    private void subMenuDriver() {
        logSubMenu(1);
        driverMenu.runDriverMenu(this);
    }

    private void subMenuVehicle() {
        logSubMenu(2);
        vehicleMenu.runVehicleMenu(this);
    }

    private void subMenuRoute() {
        logSubMenu(3);
        routesMenu.runRoutesMenu(this);
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = mainMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    public void menu() {
        SYSOUT.info("GŁÓWNE MENU");
        printMenu(mainMenu.getMenuItems());
        serviceMainMenu();
    }

    private void serviceMainMenu() {
        int item = 0;
        while (item != 4) {
            item = getMenuItem();
            switch (item) {
                case 1 -> subMenuDriver();
                case 2 -> subMenuVehicle();
                case 3 -> subMenuRoute();
                case 4 -> {
                item = 4;}
            default -> {
                log.info("User incorrectly wrote " + item + " in menu");
            }
        }
    }

}

    private void printMenu(List<String> menuItems) {
        for (String item : menuItems) {
            SYSOUT.info(item);
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

}
