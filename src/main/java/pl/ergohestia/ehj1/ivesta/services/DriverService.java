package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DriverConfig;
import pl.ergohestia.ehj1.ivesta.model.Driver;
import pl.ergohestia.ehj1.ivesta.ui.MenuService;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
public class DriverService extends DriverConfig implements Service<Driver> {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private List<Driver> driversList;

    private DriverConverter converter = new DriverConverter();

    public DriverService(String filePath) {
        super(filePath);
    }

    public List<Driver> importDrivers() {
        try (FileReader fileReader = new FileReader(super.driverPath.toString())) {
            driversList = DRIVERS_CSV_FORMAT
                    .parse(fileReader)
                    .stream()
                    .map(converter::convertToDriver)
                    .filter(driver -> driver.getName() != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Filepath does not exist: " + driverPath.toString(), e);
            SYSOUT.error("Error while loading drivers CSV file: file does not exist.");
        }
        return driversList;
    }

    public List<Driver> getDriversList() {
        return driversList;
    }

    @Override
    public void printElements() {
        driversList.stream()
                .map(Driver::toString).forEach(SYSOUT::info);
    }

    @Override
    public void addElement(Driver driver) {
        if(driver != null) {
            driver.setNumberOfCourses(Math.abs(driver.getNumberOfCourses()));
            driver.setNumberOfKilometres(Math.abs(driver.getNumberOfKilometres()));
            driversList.add(driver);
        } else {
            log.warn("Cannot add driver to the list: driver object is null.");
            SYSOUT.warn("Driver addition to the list failed.");
        }
    }
}