package pl.ergohestia.ehj1.ivesta.services;

import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DriverConfig;
import pl.ergohestia.ehj1.ivesta.dao.DriverDao;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@NoArgsConstructor
@Slf4j
public class DriverService extends DriverConfig implements Service<DriverDto> {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final DriverDao dao = new DriverDao();

    private static List<DriverDto> driversList;

    private DriverConverter converter = new DriverConverter();

    public DriverService(String filePath) {
        super(filePath);
    }

    public List<DriverDto> importDrivers() {
        try (FileReader fileReader = new FileReader(super.driverPath.toString())) {
            driversList = DRIVERS_CSV_FORMAT
                    .parse(fileReader)
                    .stream()
                    .map(converter::convertToDriverDto)
                    .filter(driverDto -> driverDto.getName() != null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            log.error("Filepath does not exist: " + driverPath.toString(), e);
            SYSOUT.error("Error while loading drivers CSV file: file does not exist.");
        }
        return driversList;
    }

    public List<DriverDto> getDriversList() {
        return driversList;
    }

    public void setDriversList() {
        driversList = dao.findAll().stream().toList();
    }

    @Override
    public void printElements() {
        driversList.stream()
                .map(DriverDto::toString).forEach(SYSOUT::info);
    }

    @Override
    public void addElement(DriverDto driverDto) {
        if (driverDto != null) {
            driverDto.setNumberOfCourses(driverDto.getNumberOfCourses());
            driverDto.setNumberOfKilometres(driverDto.getNumberOfKilometres());
            driversList.add(driverDto);
        } else {
            log.warn("Cannot add driver to the list: driver object is null.");
        }
    }
}
