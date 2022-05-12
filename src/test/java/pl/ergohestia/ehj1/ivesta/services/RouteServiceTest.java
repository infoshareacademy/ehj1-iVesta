package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import pl.ergohestia.ehj1.ivesta.adapters.RouteAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.repository.RouteRepository;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RouteServiceTest {

    @Autowired
    private RouteService sut;

    @Autowired
    private RouteAdapter routeAdapter;

    @MockBean
    private RouteRepository routeRepository;

    @Test
    void shouldGetEmptyListWhenNoRoutes() {
        // given
        Mockito.when(sut.getAllRoutes()).thenReturn(Collections.emptyList());

        // when
        List<RouteDto> result = sut.getAllRoutes();

        // then
        assertThat(result).hasSize(0);

    }

    @Test
    void shouldGetAllRoutes() {
        // given
        Route testRoute1 = new Route(
                "testStart",
                "testDestination",
                10,
                TransportType.CARGO,
                10,
                LocalDate.parse("2022-05-20"));
        Route testRoute2 = new Route(
                "testStart2",
                "testDestination2",
                20,
                TransportType.PASSENGERS,
                20,
                LocalDate.parse("2022-05-10"));
        Mockito.when(sut.getAllRoutes()).thenReturn(List.of(
                routeAdapter.convertToRouteDto(testRoute1),
                routeAdapter.convertToRouteDto(testRoute2)));

        // when
        List<RouteDto> result = sut.getAllRoutes();

        // then
        assertThat(result).hasSize(2);

    }

    @Test
    void shouldGetRouteById() {
        // given

        // when

        // then

    }

    @Test
    void shouldAddRoute() {
        // given

        // when

        // then

    }

    @Test
    void shouldDeleteRouteById() {
        // given

        // when

        // then

    }

    @Test
    void shouldAddDriverToRoute() {
        // given

        // when

        // then

    }

    @Test
    void shouldAddVehicleToRoute() {
        // given

        // when

        // then

    }

    @Test
    void shouldGetIncompleteRoutes() {
        // given

        // when

        // then

    }
}