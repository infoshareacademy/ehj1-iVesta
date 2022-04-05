package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import static org.assertj.core.api.Assertions.assertThat;

class DriverDaoTest {

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




        // when
        DriverDto test = testDriverDto(name,lastName,address,phoneNumber,license,numberOfCourses,numberOfKilometres);
        DriverDto result= sut.save(new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000));
        DriverDto result2= sut.save(new DriverDto("2","TestLastName2","TestAddress2","TestPhone2","TestLicense2",5,3000));

        // then
        assertThat(result).isNotNull();
        assertThat(result.getName()).isEqualTo(test.getName());




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