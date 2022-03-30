package pl.ergohestia.ehj1.ivesta.services;

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

public class DriverService extends DriverConfig implements Service<Driver> {

    private static final Logger LOG = LoggerFactory.getLogger(DriverService.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private List<Driver> driversList;

    public DriverService(String filePath) {
        super(filePath);
    }

    public List<Driver> importDrivers() {
        try (FileReader fileReader = new FileReader(super.driverPath.toString())) {
            driversList = DRIVERS_CSV_FORMAT
                    .parse(fileReader)
                    .stream()
                    .map(csvRecord -> convertToDriver(csvRecord))
                    .filter(driver -> driver.getName() != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
            SYSOUT.error("Error while loading drivers CSV file: file does not exist.");
        }
        return driversList;
    }

    private Driver convertToDriver(CSVRecord csvRecord) {
        Driver driver = new Driver(null,null,null,null,null,null,null);
        try {
            driver.setName(csvRecord.get(0));
            driver.setLastName(csvRecord.get(1));
            driver.setAddress(csvRecord.get(2));
            driver.setPhoneNumber(csvRecord.get(3));
            driver.setLicense(csvRecord.get(4));
            driver.setNumberOfCourses(Integer.valueOf(csvRecord.get(5)));
            driver.setNumberOfKilometres(Integer.valueOf(csvRecord.get(6)));
        } catch (NumberFormatException e) {
            SYSOUT.warn("Cannot read csv record: numerical columns have incorrect values.");
        } catch (NullPointerException e) {
            SYSOUT.warn("Cannot read csv record: columns without values have been found.");
        }
        return driver;
    }

    public List<Driver> getDriversList() {
        return driversList;
    }

    @Override
    public void printElements() {
        driversList.stream()
                .forEach(System.out::println);
    }

    @Override
    public void addElement(Driver driver) {
        if(driver != null) {
            driversList.add(driver);
        } else {
            LOG.warn("Cannot add driver to the list: driver object is null.");
            SYSOUT.warn("Driver addition to the list failed.");
        }
    }
}