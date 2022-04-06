package pl.ergohestia.ehj1.ivesta.ui;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.services.DriverService;
import pl.ergohestia.ehj1.ivesta.services.VehicleService;

@Slf4j
public class DriverMenu {

    private Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private InputScannerProvider in = new InputScannerProvider();

    DriverService driverService = new DriverService();

    public void runDriverMenu(){
        printMenu(vehicleMenu.getMenuItems());
        serviceVehicleMenu();
    }
}
