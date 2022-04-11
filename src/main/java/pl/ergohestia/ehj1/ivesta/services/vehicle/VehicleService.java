package pl.ergohestia.ehj1.ivesta.services.vehicle;

import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.dao.VehicleDao;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.VehiclesLoader;
import pl.ergohestia.ehj1.ivesta.services.ProperDateValidator;
import pl.ergohestia.ehj1.ivesta.services.Service;
import pl.ergohestia.ehj1.ivesta.ui.VehicleEditor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.in;


@NoArgsConstructor
public class VehicleService implements Service<VehicleDto> {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");
    private static final Logger LOG = LoggerFactory.getLogger(VehicleService.class);

    private final VehicleDao vehicleDao = new VehicleDao();
    private Collection<VehicleDto> vehicleDtoList;
    VehicleValidator validator = new VehicleValidator();

    public VehicleService(List<VehicleDto> vehicleDtoList) {
        this.vehicleDtoList = vehicleDtoList;
    }

    public void loadVehicle() {
        VehiclesLoader vehiclesLoader = new VehiclesLoader();
        vehicleDtoList = vehiclesLoader.getListOfVehicles();
        Collection<VehicleDto> validList = saveValidVehicles();
        for (VehicleDto vehicleDto : validList) {
            LOG.info("Added vehicle to database: " + vehicleDto);
            vehicleDao.save(vehicleDto);
        }
        SYSOUT.info("Ilość pojazdów dodanych do bazy danych: " + vehicleDtoList.size());
    }

    public void editVehicles() {
        Scanner scanner = new Scanner(in);
        vehicleDtoList = getVehicleDtoList();
        List<VehicleDto> list = new ArrayList(vehicleDtoList);
        printVehicles(list);
        SYSOUT.info("Podaj numer pojazdu, który chciałbyś edytować lub wpisz 0 aby zakończyć edycję:");
        String input = scanner.nextLine();
        int number = Integer.parseInt(getNumberFromUser(scanner, input));
        while (number > list.size()) {
            SYSOUT.warn("Podany numer nie istnieje! Maksymalny numer to : " + list.size());
            input = scanner.nextLine();
            number = Integer.parseInt(getNumberFromUser(scanner, input));
        }
        if (number == 0) {
            SYSOUT.info("Edycja zakończona");
        } else {
            VehicleEditor vehicleEditor = new VehicleEditor(list.get(number - 1));
            vehicleDao.update(vehicleEditor.editVehicle(in));
        }
    }

    private String getNumberFromUser(Scanner scanner, String input) {
        while (!Service.isNumeric(input)) {
            SYSOUT.warn("Niepoprawny numer: " + input + ". Podaj numer ponownie");
            input = scanner.nextLine();
        }
        return input;
    }

    public Collection<VehicleDto> getVehicleDtoList() {
        return vehicleDao.findAll();
    }

    private Collection<VehicleDto> saveValidVehicles() {
        Collection<VehicleDto> finalCollection = new ArrayList<>();
        for (VehicleDto vehicleDto : vehicleDtoList) {
            vehicleDto = validator.validateConfigOfYearAndMethodProduction(vehicleDto);
            VehicleValidator vehicleValidator = new VehicleValidator(vehicleDto);

            if (vehicleValidator.isVehicleValid()) {
                SYSOUT.info("Vehicle is valid: " + vehicleDto);
                LOG.info("Vehicle will be saved in db: " + vehicleDto);
                finalCollection.add(vehicleDto);
            } else {
                SYSOUT.warn("Usunięto pojazd z niepoprawnymi danymi: " + vehicleDto);
            }
        }
        return finalCollection;
    }

    public Collection<VehicleDto> getVehiclesList() {
        return vehicleDtoList;
    }

    /*public List<VehicleDto> findVehicleByDate(LocalDate date) {
        if (dateValidator.isValid(String.valueOf(date).replace("-",""))) {
            return vehicleDao.findVehicleByDate(date);
        } else SYSOUT.warn("Date must be in format: YYYY-MM-DD");
        return null;
    }*/

    @Override
    public void printElements() {
        vehicleDtoList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    @Override
    public void addElement(VehicleDto vehicleDto) {
        vehicleDtoList.add(vehicleDto);
    }

    private void printVehicles(List<VehicleDto> list) {
        int i = 1;
        for (VehicleDto vehicleDto : list) {
            SYSOUT.info(i + ". " + vehicleDto);
            i++;
        }
    }
}
