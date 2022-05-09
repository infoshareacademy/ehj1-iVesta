package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.csv.CSVRecord;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.LicenseType;

@Slf4j
public class DriverConverter {

    public DriverDto convertToDriverDto(CSVRecord csvRecord) {
        DriverDto driverDto = new DriverDto();
        try {
            driverDto.setName(csvRecord.get(0));
            driverDto.setLastName(csvRecord.get(1));
            driverDto.setPhoneNumber(csvRecord.get(3));
            driverDto.setLicense(LicenseType.valueOf(csvRecord.get(4)));
        } catch (NumberFormatException | NullPointerException e) {
            log.warn("Cannot read csv record: columns have incorrect values.", e);
        }
        return driverDto;
    }
}
