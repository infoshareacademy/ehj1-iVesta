package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.services.DriverService;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;

@Slf4j
public class DriverMenu {

    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    DriverService driverService = new DriverService();

    public void runDriverMenu() {
        serviceDriverMenu();
    }

    private final Menu driverMenu = new Menu(
            "1. Wyświetl wszystkich kierowców.",
            "2. Wyświetl dostępnych kierowców.",
            "3. Edytuj kierowców.",
            "4. Załaduj nowych kierowców.",
            "5. Wróć do głównego menu.");

    private void subMenuShowAllDrivers() {
        logSubMenu(1);
        List<DriverDto> list = driverService.getAllDrivers();
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
        List<DriverDto> list = driverService.getAllDrivers();
        if (!(list == null) && !list.isEmpty()) {
            driverService.editDriversData(list);
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
        int item = 0;
        while (item != 5) {
            printMenu(driverMenu.getMenuItems());
            item = getMenuItem();
            switch (item) {
                case 1 -> subMenuShowAllDrivers();
                case 2 -> subMenuShowAvailableDrivers();
                case 3 -> subMenuEditDrivers();
                case 4 -> subMenuLoadNewDrivers();
                case 5 -> logSubMenu(5);
                default -> {
                    log.info("User incorrectly wrote " + item + " in menu");
                    continue;
                }
            }
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
        Scanner scanner;
        Path filePath = null;
        do {
            SYSOUT.info("Podaj ścieżkę do pliku CSV z nowymi kierowcami: ");
            scanner = new Scanner(System.in);
            String nextLine = scanner.nextLine();
            if (nextLine.isBlank()) {
                log.info("User wrote nothing while passing drivers filepath.");
                SYSOUT.info("Nie podałeś ścieżki do pliku.");
            }
            if (!nextLine.isBlank()) {
                Boolean fileExist = new File(nextLine).isFile();
                if (fileExist) {
                    filePath = Paths.get(nextLine);
                } else {
                    log.info("User wrote filepath that does not exist.");
                    SYSOUT.info("Podana ścieżka nie istnieje.");
                }
            }
        } while (filePath == null);
        return filePath;
    }

    private void printMenu(List<String> menuItems) {
        for (String item : menuItems) {
            SYSOUT.info(item);
        }
    }
}
