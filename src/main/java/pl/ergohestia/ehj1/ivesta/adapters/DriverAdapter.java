package pl.ergohestia.ehj1.ivesta.adapters;

import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

public class DriverAdapter {
    public DriverDto convertToDriverDto(Driver driver) {
        if (driver == null) {
            return null;
        }
        DriverDto driverDto = new DriverDto(driver.getName(),
                driver.getLastName(),
                driver.getAddress(),
                driver.getPhoneNumber(),
                driver.getLicense(),
                driver.getNumberOfCourses(),
                driver.getNumberOfKilometres()
        );
        driverDto.setId(driver.getId());
        return driverDto;
    }
}
