package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

@Slf4j
public class DriverConverter {
    public DriverDto convertToDriverDto(CSVRecord csvRecord) {
        try {
        DriverDto driverDto = new DriverDto(
            driverDto.setName(csvRecord.get(0)),
            driverDto.setLastName(csvRecord.get(1)),
            driverDto.setAddress(csvRecord.get(2))
            driverDto.setPhoneNumber(csvRecord.get(3));
            driverDto.setLicense(csvRecord.get(4));
            driverDto.setNumberOfCourses(Math.abs(Integer.valueOf(csvRecord.get(5))));
            driverDto.setNumberOfKilometres(Math.abs(Integer.valueOf(csvRecord.get(6))));
        } catch (NumberFormatException e) {
            log.warn("Cannot read csv record: numerical columns have incorrect values.", e);
        } catch (NullPointerException e) {
            log.warn("Cannot read csv record: columns without values have been found.", e);
        }
        return driverDto;
    }
}
