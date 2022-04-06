package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.configs.DefaultVehiclePath;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.vehicle.VehicleService;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleDtoServiceTest {

    private VehicleService sut;

    @Test
    void shouldResultFromDefaultPathBeEqualToTestPath() {
        // given
        Path TEST_PATH = Path.of(("src/main/resources/input.json"));
        DefaultVehiclePath path = new DefaultVehiclePath();

        // when

        // then
        assertThat(TEST_PATH).isEqualTo(path.vehiclePath);
    }
}