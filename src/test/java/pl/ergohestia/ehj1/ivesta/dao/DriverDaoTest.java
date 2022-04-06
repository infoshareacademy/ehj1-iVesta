package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.ergohestia.ehj1.ivesta.utils.HibernateUtils.em;

class DriverDaoTest {

    @AfterEach
    void cleanDb(){
        em.getTransaction().begin();
        em.createQuery("delete Driver").executeUpdate();
        em.getTransaction().commit();
    }

    DriverDto test = new DriverDto("TestName","TestLastName","TestAddress","TestPhone","TestLicense",5,3000);
    DriverDto test2 =new DriverDto("TestName2","TestLastName2","TestAddress2","TestPhone2","TestLicense2",2,1000);

    private DriverDao sut = new DriverDao();

    @Test
    void shouldSaveNewDriver() {
        // given



        // when
        sut.save(test);


        // then
        assertThat(test).isNotNull();
        assertThat(test.getName()).isEqualTo("TestName");
    }

    @Test
    void shouldFindByID() {
        // given
        sut.save(test);

        // when
        Collection<DriverDto> dtoCollection = sut.findAll();
        List<UUID> id = dtoCollection.stream().map(DriverDto::getId).collect(Collectors.toList());
        UUID resultUUID = id.get(0);

        // then
        assertThat(sut.find(resultUUID)).isNotNull();


    }

    @Test
    void shouldFindAll() {
        // given
        sut.save(test);
        sut.save(test2);

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
        sut.save(test);
        DriverDto firstResult = sut.findAll().iterator().next();

        // when
        firstResult.setLicense("C");
        firstResult.setName("Johny");
        sut.update(firstResult);
        Collection<DriverDto> result = sut.findAll();
        DriverDto resultDriver = sut.findAll().iterator().next();

        // then
        assertThat(resultDriver.getName().equals("Johny"));
        assertThat(resultDriver.getLicense().equals("C"));

    }

    @Disabled
    @Test
    void shouldDelete() {
        // given
        sut.save(test);
        DriverDto firstResult = sut.findAll().iterator().next();


        // when
        sut.delete(firstResult);
        Collection<DriverDto> result = sut.findAll();

        // then
        assertThat(result).isEmpty();

    }
}