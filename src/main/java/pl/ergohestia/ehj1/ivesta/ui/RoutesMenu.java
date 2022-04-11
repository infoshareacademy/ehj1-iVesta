package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class RoutesMenu {

    private InputScannerProvider in = new InputScannerProvider();
    private Logger log = LoggerFactory.getLogger(RoutesMenu.class);
    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    RouteService routeService;
    MenuService menuService;
    RoutesLoader routesLoader;

    public void runRoutesMenu(MenuService menuService) {
        this.menuService = menuService;
        routesLoader = new RoutesLoader().init();
        routeService = new RouteService();
        serviceRouteMenu();
    }

    private final Menu routesMenu = new Menu(
            "1. Wyświetl wszystkie trasy.",
            "2. Stwórz trasę.",
            "3. Powrót do menu głównego.");

    private void printRoutes() {
        logSubMenu(1);
        Collection<RouteDto> routes = routeService.getRoutes();
        if (routes.size() == 0) {
            SYSOUT.info("Brak tras do wyświetlenia");
        }
        for (RouteDto routeDto : routes) {
            SYSOUT.info(String.valueOf(routeDto));
        }
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = routesMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    private void serviceRouteMenu() {
        int item;
        boolean isEnd = false;
        while (!isEnd) {
            printMenu(routesMenu.getMenuItems());
            item = getMenuItem();
            switch (item) {
                case 1 -> printRoutes();
                case 2 -> createRoute();
                case 3 -> isEnd = true;
                default -> {
                    log.info("User incorrectly wrote " + item + " in menu");
                }
            }
        }
        menuService.menu();
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

    public void createRoute() {
        RouteDto routeDto = routesLoader.loadRoute(in.getInputStream());
        log.debug("Loaded route: {}", routeDto);

        routeDto = routesLoader.addVehicleToRoute(in.getScanner(), routeDto);
        if (routeDto.getVehicle() == null) {
            SYSOUT.info("Brak dostępnych pojazdów w bazie.");
        } else {
            SYSOUT.info("Wybrany samochód: {}", routeDto.getVehicle().toString());
        }
        routeDto = routesLoader.addDriverToRoute(in.getScanner(), routeDto);
        if (routeDto.getDriver() == null) {
            SYSOUT.warn("Brak dostępnych kierowców w bazie danych");
        } else {
            SYSOUT.info("Wybrany kierowca: {}", routeDto.getDriver());
        }

        if (routeDto.getVehicle() == null || routeDto.getDriver() == null) {
            SYSOUT.warn("Nie udało się zapisać trasy");
        } else {
            routeService.saveRoute(routeDto);
            SYSOUT.info("Dodano trasę: {}", routeDto);
        }
    }
}

