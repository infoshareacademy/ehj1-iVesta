package pl.ergohestia.ehj1.ivesta.UI;

import pl.ergohestia.ehj1.ivesta.services.CarService;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.Scanner;

public class MenuCLI {

    CarService carService = new CarService();
    DriverService driverService = new DriverService();
    RouteService routeService = new RouteService();

    public void printMainMenu() {
        System.out.println("Witaj w aplikacji iVesta!\n");
        System.out.println("Wybierz jedną z poniższych opcji:");
        System.out.println("1. Wyświetl kierowców.");
        System.out.println("2. Wyświetl samochody.");
        System.out.println("3. Zaplanuj trasę.");
    }

    public int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        int item = 0;
        do {
            System.out.print("Wybierz numer z menu: ");
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
