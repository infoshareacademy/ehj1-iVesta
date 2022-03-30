package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.Driver;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class DriverServiceTest {

    public static final String TEST_FILE_PATH = "src/test/resources/driversTestFile.csv";
    private DriverService sut = new DriverService(TEST_FILE_PATH);

    @Test
    void shouldReturnDriversListWhenCsvFileIsCorrect() {
        // given

        // when
        List<Driver> result = sut.importDrivers();

        // then
        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(2);
    }

    @Test
    void shouldAddElement() {
        // given
        Driver testDriver = new Driver("test","test","test","test","test",1,1);

        // when
        sut.importDrivers();
        sut.addElement(testDriver);
        List<Driver> result = sut.getDriversList();

        // then
        assertThat(result).isNotNull();
        assertThat(result.get(result.size()-1)).isEqualTo(testDriver);
    }

    private List<Driver> createTestList() {
        Driver driver1 = new Driver("imie1","nazwisko1","adres1","0","licencja1",1,2);
        Driver driver2 = new Driver("imie2","nazwisko2","adres2","0","licencja2",2,3);
        return List.of(driver1, driver2);
    }
}