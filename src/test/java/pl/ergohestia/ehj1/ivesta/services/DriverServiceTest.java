package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriverServiceTest {

    public static final String TEST_FILE_PATH = "src/test/resources/driversTestFile.csv";
    private DriverService sut = new DriverService(TEST_FILE_PATH);

    @Test
    void shouldReturnDriversListFromCsvWhenFileIsCorrect() {
        // given

        // when
        List<DriverDto> result = sut.importDrivers();

        // then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shouldAddElementToDriversList() {
        // given
        DriverDto testDriverDto = new DriverDto("test","test","test","test","test",1,1);

        // when
        sut.importDrivers();
        sut.addElement(testDriverDto);
        List<DriverDto> result = sut.getDriversList();

        // then
        assertThat(result).isNotNull();
        assertThat(result.get(result.size()-1)).isEqualTo(testDriverDto);
    }
}