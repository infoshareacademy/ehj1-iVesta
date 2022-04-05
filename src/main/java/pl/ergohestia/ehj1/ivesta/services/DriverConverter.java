package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Driver;

@Slf4j
public class DriverConverter {

    public Driver convertToDriver(CSVRecord csvRecord) {
        Driver driver = new Driver();
        try {
            driver.setName(csvRecord.get(0));
            driver.setLastName(csvRecord.get(1));
            driver.setAddress(csvRecord.get(2));
            driver.setPhoneNumber(csvRecord.get(3));
            driver.setLicense(csvRecord.get(4));
            driver.setNumberOfCourses(Math.abs(Integer.valueOf(csvRecord.get(5))));
            driver.setNumberOfKilometres(Math.abs(Integer.valueOf(csvRecord.get(6))));
        } catch (NumberFormatException e) {
            log.warn("Cannot read csv record: numerical columns have incorrect values.", e);
        } catch (NullPointerException e) {
            log.warn("Cannot read csv record: columns without values have been found.", e);
        }
        return driver;
    }
}
