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
import java.util.Optional;
import java.util.Scanner;
import java.util.UUID;
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
                    .peek(dao::save)
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

    public List<DriverDto> getAllDrivers() {
        return dao.findAll().stream().toList();
    }

    public List<DriverDto> getAvailableDrivers() {
        return dao.findAvailable().stream().toList();
    }

    public Optional<DriverDto> findById(UUID id) {
        return Optional.ofNullable(dao.find(id));
    }

    public void editDriversData(List<DriverDto> list) {
        Scanner scanner;
        String nextLine;
        for (DriverDto driver : list) {
            String name;
            String lastName;
            String address;
            String phoneNumber;
            String license;
            SYSOUT.info(("Wyświetlam kolejnego kierowcę."));
            SYSOUT.info(driver.toString());
            SYSOUT.info("Jeśli chcesz dokonać zmiany danych, wpisz nową wartość.");
            SYSOUT.info("Imię: " + driver.getName());
            scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();
            if (!nextLine.isBlank()) {
                name = nextLine;
            } else {
                name = driver.getName();
            }
            SYSOUT.info("Nazwisko: " + driver.getLastName());
            scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();
            if (!nextLine.isBlank()) {
                lastName = nextLine;
            } else {
                lastName = driver.getLastName();
            }
            SYSOUT.info("Adres: " + driver.getAddress());
            scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();
            if (!nextLine.isBlank()) {
                address = nextLine;
            } else {
                address = driver.getAddress();
            }
            SYSOUT.info("Numer telefonu: " + driver.getPhoneNumber());
            scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();
            if (!nextLine.isBlank()) {
                phoneNumber = nextLine;
            } else {
                phoneNumber = driver.getPhoneNumber();
            }
            SYSOUT.info("Licencja: " + driver.getLicense());
            scanner = new Scanner(System.in);
            nextLine = scanner.nextLine();
            if (!nextLine.isBlank()) {
                license = nextLine;
            } else {
                license = driver.getLicense();
            }
            updateDriverPersonalData(driver.getId(), name, lastName, address, phoneNumber, license);
        }
    }

    public Optional<DriverDto> updateDriverPersonalData(UUID id, String name, String lastName, String address, String phoneNumber, String license) {
        Optional<DriverDto> driver = findById(id);
        if (driver.isPresent()) {
            DriverDto driverValue = new DriverDto(
                    driver.get().getId(),
                    name,
                    lastName,
                    address,
                    phoneNumber,
                    license,
                    driver.get().getNumberOfCourses(),
                    driver.get().getNumberOfKilometres());
            driver = Optional.ofNullable(dao.update(driverValue));
        }
        return driver;
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
