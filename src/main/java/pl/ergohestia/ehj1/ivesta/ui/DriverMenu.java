package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Menu;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

import java.io.File;
import java.nio.file.Path;
import java.util.Collection;
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

    private void subDriverMenuNo1() {
        logSubMenu(1);
        driverService.printElements();
    }

    private void subDriverMenuNo2(
            //TODO implementacja dla wyświetlania kierowców nieprzypisanych do trasy
    ) {
        logSubMenu(2);
    }

    private void subDriverMenuNo3() {
        logSubMenu(3);
    }

    private void subDriverMenuNo4() {
        logSubMenu(4);
        driverService.setDriverPath(Path.of("path"));
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
                case 1 -> subDriverMenuNo1();
                case 2 -> subDriverMenuNo2();
                case 3 -> subDriverMenuNo3();
                case 4 -> subDriverMenuNo4();
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

    private String getDriverFilePathFromInput() {
        Scanner scanner = in.getScanner();
        String filePath = null;
        do {
            SYSOUT.info("Podaj ścieżkę do pliku CSV z nowymi kierowcami: ");
            if (!scanner.hasNextLine()) {
                log.info("User wrote nothing while passing drivers filepath.");
                SYSOUT.info("Nie podałeś ścieżki do pliku.");
            }
            if (scanner.hasNextLine()) {
                Boolean fileExist = new File(filePath).isFile();
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
