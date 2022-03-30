package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.Vehicle;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class VehicleValidatorTest {

    VehicleValidator sut;
    Vehicle testVehicle = new Vehicle("Peugeot", "A1", "201","osobowy", "1991", null, 2000, 69, 0, 6, "ON", 0,25);
    Vehicle testVehicle1 = new Vehicle("Peugeot", null, "201","osobowy", null, "199", 2000, 69, 0, 0, "ON", 0,0);

    @Test
    void shouldGetValidVehicle() {
        //given
        sut = new VehicleValidator(testVehicle);
        boolean result;

        //when
        result = sut.isVehicleValid();

        //then
        assertThat(result).isTrue();
    }

    @Test
    void shouldGetNotValidParametersList() {
        //given
        sut = new VehicleValidator(testVehicle1);
        sut.isVehicleValid();
        List<String> result;

        //when
        result = sut.getNotValidParameters();

        //then
        assertThat(result.size()).isGreaterThan(0);
    }

    @Test
    void shouldGetNotValidYearProduction() {
        //given
        sut = new VehicleValidator(testVehicle1);

        //when
        sut.validateYearProduction();

        //then
        assertThat(sut.getNotValidParameters().size()).isEqualTo(1);
        assertThat(sut.getNotValidParameters().get(0)).isEqualTo("Production year");
    }

    @Test
    void shouldGetNotValidSeats() {
        //given
        sut = new VehicleValidator(testVehicle1);

        //when
        sut.validateSeats();

        //then
        assertThat(sut.getNotValidParameters().size()).isEqualTo(1);
        assertThat(sut.getNotValidParameters().get(0)).isEqualTo("Seats");
    }

    @Test
    void shouldGetNotValidMaxWeight() {
        //given
        sut = new VehicleValidator(testVehicle1);

        //when
        sut.validateWeightLimit();

        //then
        assertThat(sut.getNotValidParameters().size()).isEqualTo(1);
        assertThat(sut.getNotValidParameters().get(0)).isEqualTo("Max weight");
    }

    @Test
    void shouldGetNotValidVehicleType() {
        //given
        sut = new VehicleValidator(testVehicle1);

        //when
        sut.validateVehicleCategory();

        //then
        assertThat(sut.getNotValidParameters().size()).isEqualTo(1);
        assertThat(sut.getNotValidParameters().get(0)).isEqualTo("Vehicle category");
    }
}