package pl.ergohestia.ehj1.ivesta.configs;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;

@Getter
@Setter
public class DefaultVehiclePath {

    public final Path vehiclePath;

    public DefaultVehiclePath() {
        this.vehiclePath  = Path.of("src/main/resources/input.json");
    }

    public DefaultVehiclePath(String pathName){
        this.vehiclePath = Path.of(pathName);
    }
}
