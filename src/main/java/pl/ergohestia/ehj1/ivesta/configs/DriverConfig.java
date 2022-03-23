package pl.ergohestia.ehj1.ivesta.configs;

import org.apache.commons.csv.CSVFormat;
import pl.ergohestia.ehj1.ivesta.utils.DriverHeaders;

import java.nio.file.Path;

public class DriverConfig {

    private static Path driverPath;

    private static final CSVFormat DRIVERS_CSV_FORMAT = CSVFormat.RFC4180.builder()
            .setDelimiter(";")
            .setHeader(DriverHeaders.class)
            .setSkipHeaderRecord(true)
            .build();

    public DriverConfig(String filePath) {
        this.driverPath = Path.of(filePath);
    }
}