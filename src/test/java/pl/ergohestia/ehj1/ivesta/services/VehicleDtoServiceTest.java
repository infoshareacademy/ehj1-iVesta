package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.configs.DefaultVehiclePath;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.nio.file.Path;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleDtoServiceTest {
    private VehicleService sut;

    @Test
    void shouldGetVehiclesList() {
        //given
        sut = new VehicleService();


        //when
        List<VehicleDto> result = sut.getVehiclesList();
        sut.printElements();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void addVehicleToList() {
        //given
        sut = new VehicleService();

        //when
        sut.addElement(new VehicleDto());
        List<VehicleDto> result = sut.getVehiclesList();

        //then
        assertThat(result.size()).isEqualTo(3);
    }
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