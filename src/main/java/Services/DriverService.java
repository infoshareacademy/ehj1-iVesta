package Services;

import model.Driver;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import utils.DriversFileHeaders;

import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

public class DriverService implements Service {

    private static Path driversPath;

    private static List<Driver> driversList;

    private static final CSVFormat DRIVERS_CSV_FORMAT = CSVFormat.RFC4180.builder()
            .setSkipHeaderRecord(true)
            .setHeader(DriversFileHeaders.class)
            .build();

    public DriverService(String driversPathStr) {
        this.driversPath = Path.of(driversPathStr);
    }

    public List<Driver> importDrivers () {
        try (FileReader fileReader = new FileReader(driversPath.toString());) {
            driversList = DRIVERS_CSV_FORMAT
                    .parse(fileReader)
                    .stream()
                    .map(csvRecord -> {
                        try {
                            return convertToDriver(csvRecord);
                        } catch (NoSuchElementException e) {
                            //TODO log error;
                            return null;
                        }
                    })
                    .filter(driver -> driver!=null)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            //TODO log error
        }
        return driversList;
    }

    private static Driver convertToDriver(CSVRecord csvRecord) {
        return new Driver(
                csvRecord.get(0),
                csvRecord.get(1),
                csvRecord.get(2),
                csvRecord.get(3),
                csvRecord.get(4),
                Integer.valueOf(csvRecord.get(5)),
                Integer.valueOf(csvRecord.get(6))
        );
    }

    //TODO implementacja metody
    @Override
    public void printElements() {
        driversList.stream()
                .forEach(System.out::println);
    }

    //TODO implementacja metody
    @Override
    public void addElement() {
    }
}
