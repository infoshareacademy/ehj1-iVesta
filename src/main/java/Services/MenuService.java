package Services;

import java.util.Scanner;

public class MenuService {

    CarService carService = new CarService();
    DriverService driverService = new DriverService();
    RouteService routeService = new RouteService();

    public int getMenuItem() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Pozycja z menu: ");
        int item = scanner.nextInt();
        return item;
    }

    //TODO sprawdzenie poprawności podawanych wartości w scannerze przez użytkownika
    public void printMainMenu() {
        System.out.println("Witaj w aplikacji iVesta!\n");
        System.out.println("Wybierz jedną z poniższych opcji:");
        System.out.println("1. Wyświetl kierowców.");
        System.out.println("2. Wyświetl samochody.");
        System.out.println("3. Zaplanuj trasę.");
    }

    public void handleMainManu(int item) {
        if (item == 1) {
            System.out.println("Samochody");
            carService.printCars();
        } else if (item == 2) {
            System.out.println("Kierowcy");
            driverService.printDrivers();
        } else if (item == 3) {
            System.out.println("Trasy");
            routeService.printRoutes();
        }
    }


}
