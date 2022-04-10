package pl.ergohestia.ehj1.ivesta.adapters;

import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

public class DriverAdapter {
    public DriverDto convertToDriverDto(Driver driver) {
        if (driver == null) {
            return null;
        }
        DriverDto driverDto = new DriverDto(
                driver.getName(),
                driver.getLastName(),
                driver.getAddress(),
                driver.getPhoneNumber(),
                driver.getLicense(),
                driver.getNumberOfCourses(),
                driver.getNumberOfKilometres());
        driverDto.setId(driver.getId());
        return driverDto;
    }

    public Driver convertToDriver(DriverDto driverDto){
        if (driverDto == null) {
            return null;
        }
        Driver driver = new Driver(
                driverDto.getName(),
                driverDto.getLastName(),
                driverDto.getAddress(),
                driverDto.getPhoneNumber(),
                driverDto.getLicense(),
                driverDto.getNumberOfCourses(),
                driverDto.getNumberOfKilometres());
        driver.setId(driverDto.getId());
        return driver;
    }
}
