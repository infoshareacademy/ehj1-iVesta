package pl.ergohestia.ehj1.ivesta.configs;

import lombok.NoArgsConstructor;
import org.apache.commons.csv.CSVFormat;
import pl.ergohestia.ehj1.ivesta.repository.DriverHeaders;

import java.nio.file.Path;

@NoArgsConstructor
public class DriverConfig {

    protected static Path driverPath;

    protected static final String CSV_DELIMITER = ";";

    protected static final CSVFormat DRIVERS_CSV_FORMAT = CSVFormat.RFC4180.builder()
            .setDelimiter(CSV_DELIMITER)
            .setHeader(DriverHeaders.class)
            .setSkipHeaderRecord(true)
            .build();

    protected DriverConfig(String filePath) {
        this.driverPath = Path.of(filePath);
    }

    public void setDriverPath(Path driverPath) {
        this.driverPath = driverPath;
    }

    public static Path getDriverPath() {
        return driverPath;
    }
}