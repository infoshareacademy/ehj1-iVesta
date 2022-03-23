package pl.ergohestia.ehj1.ivesta.UI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.Main;
import pl.ergohestia.ehj1.ivesta.services.CarService;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.Scanner;

public class MenuCLI {

    private static final Logger log = LoggerFactory.getLogger(MenuCLI.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    CarService carService = new CarService();
    DriverService driverService = new DriverService();
    RouteService routeService = new RouteService();

    public void printMainMenu() {
        SYSOUT.info("Witaj w aplikacji iVesta!\n");
        SYSOUT.info("Wybierz jedną z poniższych opcji:");
        SYSOUT.info("1. Wyświetl kierowców.");
        SYSOUT.info("2. Wyświetl samochody.");
        SYSOUT.info("3. Zaplanuj trasę.");
    }

    public int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        do {
            SYSOUT.info("Wybierz numer z menu: ");
            if(!scanner.hasNextInt()){
                scanner.next();
                continue;
            }
            item = scanner.nextInt();
        } while (item < 1);

        return item;
    }

    public void serviceMainMenu(int item) {
        switch (item) {
            case 1 -> carService.printElements();
            case 2 -> driverService.printElements();
            case 3 -> routeService.printElements();
            default -> handleMainMenu();
        }
    }

    public void handleMainMenu(){
        int menuItem = getMenuItem();
        serviceMainMenu(menuItem);
    }


}
