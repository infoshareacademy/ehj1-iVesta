package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import java.util.Collection;
import static org.assertj.core.api.Assertions.assertThat;

class DriverDaoTest {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private DriverDao sut = new DriverDao();

    DriverDto testDriver = new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000);

    @Test
    void shouldSaveNewDriver() {
        // given
        String name = "TestName";
        String lastName= "TestLastName";
        String address = "TestAddress";
        String phoneNumber = "TestPhone";
        String license = "TestLicense";
        Integer numberOfCourses = 5;
        Integer numberOfKilometres = 3000;
        DriverDto test = new DriverDto(name,lastName,address,phoneNumber,license,numberOfCourses,numberOfKilometres);

        // when
        sut.save(test);
        DriverDto result = sut.findAll().iterator().next();

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(test.getName());
    }

    @Test
    void shouldFindByID() {
        // given
        sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));
        sut.save(new DriverDto("2","TestLastName2","TestAddress2","TestPhone2","TestLicense2",5,3000));

        // when
        Collection<DriverDto> result = sut.findAll();

        // then


    }
}