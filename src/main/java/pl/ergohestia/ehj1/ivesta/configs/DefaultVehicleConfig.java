package pl.ergohestia.ehj1.ivesta.configs;

import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

@Getter

public class DefaultVehicleConfig {

    Path defaultPath;

    public Path DefaultVehicleConfig() {
        defaultPath = Path.of("src", "main", "resources", "input.json");
        return defaultPath;
    }
}
