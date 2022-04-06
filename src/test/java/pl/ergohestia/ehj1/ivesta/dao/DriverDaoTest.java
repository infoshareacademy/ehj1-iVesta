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
        DriverDto test = testDriverDto(name,lastName,address,phoneNumber,license,numberOfCourses,numberOfKilometres);


        // when
        DriverDto result= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));



        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(test.getName());
    }


    @Test
    void shouldFindByID() {
        // given
        DriverDto d1= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));
        DriverDto d2= sut.save(new DriverDto("2","TestLastName2","TestAddress2","TestPhone2","TestLicense2",5,3000));



        // when




        // then






    }

    @Test
    void shouldFindAll() {
        // given
        DriverDto d1= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));
        DriverDto d2= sut.save(new DriverDto("2","TestLastName2","TestAddress2","TestPhone2","TestLicense2",5,3000));

        // when
        Collection<DriverDto> result = sut.findAll();

        // then
        assertThat(result).isNotNull();
        assertThat(result).isNotEmpty();
        assertThat(result).size().isEqualTo(2);

    }

    @Test
    void shouldUpdate() {
        // given
        DriverDto d1= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));


        // when


        // then


    }

    @Test
    void shouldDelete() {
        // given
        DriverDto d1= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));


        // when
        Collection<DriverDto> result = sut.findAll();




        // then

    }

    public DriverDto testDriverDto(String name,
                                   String lastName,
                                   String address,
                                   String phoneNumber,
                                   String license,
                                   Integer numberOfCourses,
                                   Integer numberOfKilometres){
        return new DriverDto("TestName",
                "TestLastName",
                "TestAddress",
                "TestPhone",
                "TestLicense",
                5,
                3000);
    }
}