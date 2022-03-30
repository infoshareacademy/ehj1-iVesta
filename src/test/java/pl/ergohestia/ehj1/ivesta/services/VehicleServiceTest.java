package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleServiceTest {

    private VehicleService sut;

    @Test
    void shouldGetVehiclesList() {
        //given
        sut = new VehicleService();


        //when
        List<Vehicle> result = sut.getVehiclesList();
        sut.printElements();

        //then
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void addVehicleToList() {
        //given
        sut = new VehicleService();

        //when
        sut.addElement(new Vehicle());
        List<Vehicle> result = sut.getVehiclesList();

        //then
        assertThat(result.size()).isEqualTo(3);
    }

}