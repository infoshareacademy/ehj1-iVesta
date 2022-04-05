package pl.ergohestia.ehj1.ivesta.services;

import org.apache.commons.csv.CSVRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.configs.DriverConfig;
import pl.ergohestia.ehj1.ivesta.dao.DriverDao;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.ui.MenuService;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class DriverService extends DriverConfig implements Service<DriverDto> {
    
    private DriverDao driverDao;

    private static final Logger LOG = LoggerFactory.getLogger(MenuService.class);
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private static List<DriverDto> driversList;



    public DriverService(String filePath) {
        super(filePath);    }

    public List<DriverDto> importDrivers() {
        try (FileReader fileReader = new FileReader(super.driverPath.toString())) {
            driversList = DRIVERS_CSV_FORMAT
                    .parse(fileReader)
                    .stream()
                    .map(csvRecord -> convertToDriver(csvRecord))
                    .collect(Collectors.toList());
        } catch (IOException e) {
        }
        return driversList;
    }

    private static DriverDto convertToDriver(CSVRecord csvRecord) {
        return new DriverDto(
                csvRecord.get(0),
                csvRecord.get(1),
                csvRecord.get(2),
                csvRecord.get(3),
                csvRecord.get(4),
                Integer.valueOf(csvRecord.get(5)),
                Integer.valueOf(csvRecord.get(6))
        );
    }

    @Override
    public void printElements() {
        driversList.stream()
                .forEach(System.out::println);
    }

    @Override
    public void addElement(DriverDto driverDto) {
        driversList.add(driverDto);
    }
}
