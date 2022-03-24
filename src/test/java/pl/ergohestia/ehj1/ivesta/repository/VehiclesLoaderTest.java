package pl.ergohestia.ehj1.ivesta.repository;

import org.json.simple.parser.ParseException;
import org.junit.*;
import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehiclesLoaderTest {

    private static final Path TEST_PATH = Path.of(("src/main/resources/input.json"));
    private final VehiclesLoader sut = new VehiclesLoader(TEST_PATH);

    @Test
    void shouldGetVehicleList() {
        //given
        List<Vehicle> result;
        String testBrand = "BELARUS";
        double testEngineCapacity = 1998.0;

        //when
        result = sut.getListOfVehicles();

        //then
        assertThat(result.size()).isEqualTo(2);
        assertThat(result.get(0).getBrand()).isEqualTo(testBrand);
        assertThat(result.get(1).getEngineCapacity()).isEqualTo(testEngineCapacity);

    }

}