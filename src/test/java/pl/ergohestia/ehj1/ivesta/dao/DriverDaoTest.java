package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.ergohestia.ehj1.ivesta.utils.HibernateUtils.em;

class DriverDaoTest {

    DriverDto testDriver = new DriverDto("TEST_NAME", "TEST_LAST_NAME", "TEST_ADDRESS", "TEST_PHONE", "TEST_LICENSE", 5, 3000);
    DriverDto testDriver2 = new DriverDto("TEST_NAME_2", "TEST_LAST_NAME_2", "TEST_ADDRESS_2", "TEST_PHONE_2", "TEST_LICENSE_2", 2, 1000);
    RouteDto testRoute = new RouteDto("Gdańsk","Warszawa",200, TransportType.PASSENGERS,100,LocalDate.parse("2022-04-20"));
    RouteDto testRoute2 = new RouteDto("Słupsk","Szczecin",230, TransportType.PASSENGERS,300,LocalDate.parse("2022-04-21"));

    private final DriverDao sut = new DriverDao();
    private final RouteDao sut2 = new RouteDao();

    @Test
    void shouldSaveNewDriver() {
        // given
        sut.save(testDriver);

        // when
        Collection<DriverDto> dtoResultCollection = sut.findAll();

        // then
        assertThat(dtoResultCollection).isNotNull();
        assertThat(dtoResultCollection.size()).isEqualTo(1);
    }

    @Test
    void shouldFindByID() {
        // given
        sut.save(testDriver);

        // when
        Collection<DriverDto> drivers = sut.findAll();
        List<UUID> driversId = drivers.stream().map(DriverDto::getId).toList();
        UUID resultUUID = driversId.get(0);

        // then
        assertThat(sut.find(resultUUID)).isNotNull();


    }

    @Test
    void shouldFindAll() {
        // given
        sut.save(testDriver);
        sut.save(testDriver2);

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
        sut.save(testDriver);
        DriverDto firstResult = sut.findAll().iterator().next();

        // when
        firstResult.setLicense("C");
        firstResult.setName("Johny");
        sut.update(firstResult);
        Collection<DriverDto> resultList = sut.findAll();
        DriverDto resultDriver = sut.findAll().iterator().next();

        // then
        assertThat(resultDriver.getName()).isEqualTo("Johny");
        assertThat(resultDriver.getLicense()).isEqualTo("C");
    }

    @Disabled
    @Test
    void shouldDelete() {
        // given
        sut.save(testDriver);
        DriverDto firstResult = sut.findAll().iterator().next();


        // when
        sut.delete(firstResult);
        Collection<DriverDto> result = sut.findAll();


        // then
        assertThat(result).isEmpty();

    }

    @Test
    void shouldFindDriverAvailableForGivenDate() {
        // given
        sut.save(testDriver);
        sut.save(testDriver2);
        sut2.save(testRoute);
        Collection<DriverDto> allDriversList = sut.findAll();
        List<UUID> driverId = allDriversList.stream().map(DriverDto::getId).toList();
        UUID resultDriverUUID = driverId.get(0);
        Collection<RouteDto> allRouteList = sut2.findAll();
        List<UUID> routeId = allRouteList.stream().map(RouteDto::getId).toList();
        UUID resultUUID = routeId.get(0);


        // when
        RouteDto resultRoute = sut2.addDriverToRoute(resultUUID,resultDriverUUID);
        List<DriverDto> resultDriverAvailable = sut.findByDate(LocalDate.parse("2022-04-20"));


        // then
        assertThat(resultDriverAvailable.size()).isEqualTo(1);

    }
    @BeforeEach
    void cleanDriverDbAll() {
        em.getTransaction().begin();
        em.createQuery("delete Driver").executeUpdate();
        em.createQuery("delete Route ").executeUpdate();
        em.getTransaction().commit();
    }
}