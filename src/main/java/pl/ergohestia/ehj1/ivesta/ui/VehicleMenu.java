package pl.ergohestia.ehj1.ivesta.ui;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.vehicle.VehicleService;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class VehicleMenu {

    private Logger log = LoggerFactory.getLogger(VehicleMenu.class);
    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    VehicleService vehicleService = new VehicleService();
    MenuService menuService;

    public void runVehicleMenu(MenuService menuService) {
        this.menuService = menuService;
        serviceVehicleMenu();
    }

    private final Menu vehicleMenu = new Menu(
            "1. Wyświetl wszystkie pojazdy.",
            "2. Wyświetl wszystkie pojazdy bez przydzielonych kierowców.",
            "3. Załaduj nowe pojazdy.",
            "4. Edycja danych pojazdu.",
            "5. Powrót do menu głównego.");

    private void printVehicles() {
        logSubMenu(1);
        Collection<VehicleDto> vehicles = vehicleService.getVehicleDtoList();
        if (vehicles.size() == 0){
            SYSOUT.info("Brak pojazdów do wyswietlenia");
        }
        for (VehicleDto vehicleDto : vehicles) {
            SYSOUT.info(String.valueOf(vehicleDto));
        }
    }

    private void printAvailableVehicles() {
        logSubMenu(2);
        /*SYSOUT.info("Podaj date w formacie yyyy-mm-dd");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        List<VehicleDto> list = vehicleService.findByDate(LocalDate.parse(input));
        if (list.size() == 0){
            SYSOUT.warn("Brak dostępnych pojazdów na podaną datę");
        }else {
            list.forEach(vehicleDto-> SYSOUT.info(String.valueOf(vehicleDto)));
        }*/

    }

    private void loadNewVehicles() {
        logSubMenu(3);
        vehicleService.loadVehicle();
    }

    private void editVehicles() {
        logSubMenu(4);
        vehicleService.editVehicles();
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = vehicleMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    private void serviceVehicleMenu() {
        int item;
        boolean isEnd = false;
        while (!isEnd) {
            printMenu(vehicleMenu.getMenuItems());
            item = getMenuItem();
            switch (item) {
                case 1 -> printVehicles();
                case 2 -> printAvailableVehicles();
                case 3 -> loadNewVehicles();
                case 4 -> editVehicles();
                case 5 -> isEnd = true;
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
}
