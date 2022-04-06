package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.List;
import java.util.Scanner;

public class MenuService {

    private Logger log = LoggerFactory.getLogger(MenuService.class);
    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    DriverService driverService;
    RouteService routeService;
    VehicleMenu vehicleMenu;
    RoutesLoader routesLoader;

    public MenuService init() {
        driverService = new DriverService("path");
        routeService = new RouteService();
        vehicleMenu = new VehicleMenu();
        routesLoader = new RoutesLoader().init();
        return this;
    }

    private Menu mainMenu = new Menu(
            "1. Wyświetl kierowców.",
            "2. Obsługa pojazdów.",
            "3. Zaplanuj trasę.");

    private void subMenuDriver() {
        logSubMenu(1);
    }

    private void subMenuVehicle() {
        logSubMenu(2);
        vehicleMenu.runVehicleMenu();
    }

    private void subMenuRoute() {
        logSubMenu(3);
        RouteDto routeDto = routesLoader.loadRoute(in.getInputStream());
        log.debug("Loaded route: {}", routeDto);

        routeDto = routesLoader.addVehicleToRoute(in.getScanner(), routeDto);
        SYSOUT.info("Wybrany samochód: {}", routeDto.toString());
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = mainMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    public void menu() {
        printMenu(mainMenu.getMenuItems());
        serviceMainMenu();
    }

    private void serviceMainMenu() {
        int item;
        while (true) {
            item = getMenuItem();
            switch (item) {
                case 1 -> subMenuDriver();
                case 2 -> subMenuVehicle();
                case 3 -> subMenuRoute();
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
