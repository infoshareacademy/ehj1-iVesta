package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

@Slf4j
public class DriverConverter {

    public DriverDto convertToDriverDto(CSVRecord csvRecord) {
        DriverDto driverDto = new DriverDto();
        try {
            driverDto.setName(csvRecord.get(0));
            driverDto.setLastName(csvRecord.get(1));
            driverDto.setAddress(csvRecord.get(2));
            driverDto.setPhoneNumber(csvRecord.get(3));
            driverDto.setLicense(csvRecord.get(4));
            driverDto.setNumberOfCourses(Math.abs(Integer.parseInt(csvRecord.get(5))));
            driverDto.setNumberOfKilometres(Math.abs(Integer.parseInt(csvRecord.get(6))));
        } catch (NumberFormatException | NullPointerException e) {
            log.warn("Cannot read csv record: columns have incorrect values.", e);
        }
        return driverDto;
    }
}
