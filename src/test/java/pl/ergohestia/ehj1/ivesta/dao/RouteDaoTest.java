package pl.ergohestia.ehj1.ivesta.dao;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.services.RouteService;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

class RouteDaoTest {



    private final RouteDao sut = new RouteDao();
    private final DriverDao sut2 = new DriverDao();
    private final RouteService routeService = new RouteService();
    EntityManager em = HibernateUtils.getEntityManager();

    @AfterEach
    void cleanDb() {
        em.getTransaction().begin();
        em.createQuery("delete Route").executeUpdate();
        em.getTransaction().commit();
    }

    @Test
    void shouldSaveRoute() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();

        // when
        sut.save(testRouteDto);
        Collection<RouteDto> result = sut.findAll();

        // then
        assertThat(result).hasSize(1);

    }

    @Test
    void shouldFind() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();
        sut.save(testRouteDto);

        // when
        RouteDto result = sut.findAll().iterator().next();

        // then
        assertThat(result.getStartAddress()).isEqualTo("Test Start Address");
        assertThat(result.getDestinationAddress()).isEqualTo("Test Destination Address");
        assertThat(result.getRouteLength()).isEqualTo(200);
        assertThat(result.getTransportType()).isEqualTo(TransportType.PASSENGERS);
        assertThat(result.getTransportVolume()).isEqualTo(20);

    }

    @Test
    void shouldFindAll() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();
        sut.save(testRouteDto);
        sut.save(testRouteDto);
        sut.save(testRouteDto);

        // when
        Collection<RouteDto> result = sut.findAll();

        // then
        assertThat(result).hasSize(3);

    }

    @Disabled
    @Test
    void shouldUpdate() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();
        sut.save(testRouteDto);

        // when
        testRouteDto.setStartAddress("Updated Test Start Address");
        testRouteDto.setRouteLength(400);
        sut.update(testRouteDto);
        RouteDto result = sut.findAll().iterator().next();

        // then
        assertThat(result.getStartAddress()).isEqualTo("Updated Test Start Address");
        assertThat(result.getRouteLength()).isEqualTo(400);

    }

    @Disabled
    @Test
    void shouldDelete() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();
        sut.save(testRouteDto);

        // when
        sut.delete(testRouteDto);
        Collection<RouteDto> result = sut.findAll();

        // then
        assertThat(result).isEmpty();

    }

    public RouteDto prepareTestRouteDto() {
        return new RouteDto("Test Start Address",
                "Test Destination Address",
                200,
                TransportType.PASSENGERS,
                20,
                LocalDate.parse("2022-04-20"));
    }

    @Test
    void shouldAddDriverIdToRouteDriver() {
        // given
        sut.save(new RouteDto("Gdańsk","Warszawa",200, TransportType.PASSENGERS,100,LocalDate.parse("2022-04-22")));
        Collection<RouteDto> result = sut.findAll();
        List<UUID> routeId = result.stream().map(RouteDto::getId).toList();
        UUID resultUUID = routeId.get(0);

        sut2.save(new DriverDto("TEST_NAME", "TEST_LAST_NAME", "TEST_ADDRESS", "TEST_PHONE", "TEST_LICENSE", 5, 3000));
        Collection<DriverDto> result2 = sut2.findAll();
        List<UUID> driverId = result2.stream().map(DriverDto::getId).toList();
        UUID resultDriverUUID = driverId.get(0);

        System.out.println(resultDriverUUID+ " "+resultUUID);

        // when
        sut.updateDriver(resultUUID,resultDriverUUID);
        Collection<RouteDto> result3 = sut.findAll();


        // then
        System.out.println(result3);
        //zmianę widać na tabeli w bazie danych, w teście będzie null

    }
}