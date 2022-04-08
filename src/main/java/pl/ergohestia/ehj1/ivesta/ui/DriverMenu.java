package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.DriverService;

import java.io.File;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class DriverMenu {

    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    DriverService driverService = new DriverService();

    public void runDriverMenu() {
        printMenu(driverMenu.getMenuItems());
        serviceDriverMenu();
    }

    private final Menu driverMenu = new Menu(
            "1. Wyświetl wszystkich kierowców.",
            "2. Wyświetl dostępnych kierowców.",
            "3. Edytuj kierowców.",
            "4. Załaduj nowych kierowców.");

    private void subMenuShowAllDrivers() {
        logSubMenu(1);
        List<DriverDto> list = driverService.getDriversList();
        if (!(list == null) && !list.isEmpty()) {
            list.stream().map(DriverDto::toString).forEach(SYSOUT::info);
        } else {
            SYSOUT.info("Brak kierowców. Dodaj nowych.");
        }
    }

    private void subMenuShowAvailableDrivers() {
        logSubMenu(2);
        List<DriverDto> list = driverService.getAvailableDrivers();
        if (!(list == null) && !list.isEmpty()) {
            list.stream().map(DriverDto::toString).forEach(SYSOUT::info);
        } else {
            SYSOUT.info("Brak dostępnych kierowców.");
        }
    }

    private void subMenuEditDrivers() {
        logSubMenu(3);
        Scanner scanner = in.getScanner();
        List<DriverDto> list = driverService.getDriversList();
        if (!(list == null) && !list.isEmpty()) {
            for (DriverDto driver : list) {
                String name;
                String lastName;
                String address;
                String phoneNumber;
                String license;
                SYSOUT.info(("Wyświetlam kolejnego kierowcę."));
                SYSOUT.info(driver.toString());
                SYSOUT.info("Jeśli chcesz dokonać zmiany danych, wpisz nową wartość.");
                SYSOUT.info("Imię: " + driver.getName());
                if (scanner.hasNextLine()) {
                    name = scanner.nextLine();
                } else {
                    name = driver.getName();
                }
                SYSOUT.info("Nazwisko: " + driver.getLastName());
                if (scanner.hasNextLine()) {
                    lastName = scanner.nextLine();
                } else {
                    lastName = driver.getLastName();
                }
                SYSOUT.info("Adres: " + driver.getAddress());
                if (scanner.hasNextLine()) {
                    address = scanner.nextLine();
                } else {
                    address = driver.getAddress();
                }
                SYSOUT.info("Numer telefonu: " + driver.getPhoneNumber());
                if (scanner.hasNextLine()) {
                    phoneNumber = scanner.nextLine();
                } else {
                    phoneNumber = driver.getPhoneNumber();
                }
                SYSOUT.info("Licencja: " + driver.getLicense());
                if (scanner.hasNextLine()) {
                    license = scanner.nextLine();
                } else {
                    license = driver.getLicense();
                }
                driverService.updateDriverPersonalData(driver.getId(), name, lastName, address, phoneNumber, license);
            }
        } else {
            SYSOUT.info("Brak kierowców. Dodaj nowych.");
        }
    }

    private void subMenuLoadNewDrivers() {
        logSubMenu(4);
        driverService.setDriverPath(getDriverFilePathFromInput());
        driverService.importDrivers();
    }

    private void logSubMenu(int index) {
        int menuIndex = index - 1;
        String subMenuName = driverMenu.getMenuItems().get(menuIndex);
        SYSOUT.info("Wybrałeś: " + subMenuName);
        log.info("User correctly chose " + index + " in menu");
    }

    private void serviceDriverMenu() {
        int item;
        while (true) {
            item = getMenuItem();
            switch (item) {
                case 1 -> subMenuShowAllDrivers();
                case 2 -> subMenuShowAvailableDrivers();
                case 3 -> subMenuEditDrivers();
                case 4 -> subMenuLoadNewDrivers();
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

    private Path getDriverFilePathFromInput() {
        Scanner scanner = in.getScanner();
        String filePath = null;
        do {
            SYSOUT.info("Podaj ścieżkę do pliku CSV z nowymi kierowcami: ");
            if (!scanner.hasNextLine()) {
                log.info("User wrote nothing while passing drivers filepath.");
                SYSOUT.info("Nie podałeś ścieżki do pliku.");
            }
            if (scanner.hasNextLine()) {
                String filePathToCheck = scanner.nextLine();
                Boolean fileExist = new File(filePathToCheck).isFile();
                if (fileExist) {
                    filePath = filePathToCheck;
                } else {
                    log.info("User wrote filepath that does not exist.");
                    SYSOUT.info("Podana ścieżka nie istnieje.");
                }
            }
        } while (filePath == null);
        return Path.of(filePath);
    }

    private void printMenu(List<String> menuItems) {
        for (String item : menuItems) {
            SYSOUT.info(item);
        }
    }
}
