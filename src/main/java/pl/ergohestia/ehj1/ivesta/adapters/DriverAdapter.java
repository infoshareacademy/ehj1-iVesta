package pl.ergohestia.ehj1.ivesta.adapters;

import org.springframework.stereotype.Component;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

@Component
public class DriverAdapter {
    public DriverDto convertToDriverDto(Driver driver) {
        if (driver == null) {
            return null;
        }
        DriverDto driverDto = new DriverDto(
                driver.getName(),
                driver.getLastName(),
                driver.getPhoneNumber(),
                driver.getLicense(),
                driver.getAvailability());
        driverDto.setId(driver.getId());
        return driverDto;
    }

    public Driver convertToDriver(DriverDto driverDto) {
        if (driverDto == null) {
            return null;
        }
        Driver driver = new Driver(
                driverDto.getName(),
                driverDto.getLastName(),
                driverDto.getPhoneNumber(),
                driverDto.getLicense(),
                driverDto.getAvailability());
        driver.setId(driverDto.getId());
        return driver;
    }
}
