//package pl.ergohestia.ehj1.ivesta.services;
//
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import pl.ergohestia.ehj1.ivesta.model.DriverDto;
//
//import java.util.List;
//import java.util.Optional;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//class DriverServiceTest {
//
//    public static final String TEST_FILE_PATH = "src/test/resources/driversTestFile.csv";
//    private DriverService sut;
//    private DriverDto testDriverDto;
//
//    @BeforeEach
//    void beforeEach() {
//        sut = new DriverService(TEST_FILE_PATH);
//    }
//
//    @Test
//    void shouldReturnDriversListFromCsvWhenFileIsCorrect() {
//        // given
//        sut.importDrivers();
//
//        // when
//        List<DriverDto> result = sut.getDriversList();
//
//        // then
//        assertThat(result).isNotNull();
//        assertThat(result.size()).isEqualTo(2);
//    }
//
//    @Test
//    void shouldAddElementToDriversList() {
//        // given
//        sut.importDrivers();
//        testDriverDto = sut.getDriversList().get(0);
//
//        // when
//        sut.addElement(testDriverDto);
//        List<DriverDto> result = sut.getDriversList();
//
//        // then
//        assertThat(result).isNotNull();
//        assertThat(result.get(result.size() - 1)).isEqualTo(testDriverDto);
//    }
//
//    @Test
//    void shouldUpdateDriver() {
//        // given
//        sut.setDriversList();
//        testDriverDto = sut.getDriversList().get(0);
//        String newTestName = "testName2";
//        String newTestLastName = "testLastname2";
//        String newTestAddress = "testAddress2";
//        String newTestPhoneNumber = "testPhone2";
//        String newTestLicense = "testLicense2";
//
//        // when
//        sut.updateDriverPersonalData(testDriverDto.getId(), newTestName, newTestLastName, newTestAddress, newTestPhoneNumber, newTestLicense);
//        Optional<DriverDto> result = sut.findById(testDriverDto.getId());
//
//        // then
//        assertThat(result.isPresent());
//        assertThat(result.get().getName()).isEqualTo(newTestName);
//        assertThat(result.get().getLastName()).isEqualTo(newTestLastName);
//        assertThat(result.get().getAddress()).isEqualTo(newTestAddress);
//        assertThat(result.get().getPhoneNumber()).isEqualTo(newTestPhoneNumber);
//        assertThat(result.get().getLicense()).isEqualTo(newTestLicense);
//    }
//}