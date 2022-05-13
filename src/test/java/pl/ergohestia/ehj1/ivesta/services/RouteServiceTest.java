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
import pl.ergohestia.ehj1.ivesta.request.RouteRequest;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class RouteServiceTest {

    @MockBean
    private RouteRepository routeRepository;

    @Autowired
    private RouteService sut;

    @Autowired
    RouteAdapter routeAdapter;

    @Test
    void shouldGetEmptyListWhenNoRoutes() {
        // given
        Mockito.when(routeRepository.findAll()).thenReturn(Collections.emptyList());

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
        Mockito.when(routeRepository.findAll()).thenReturn(List.of(testRoute1, testRoute2));

        // when
        List<RouteDto> result = sut.getAllRoutes();

        // then
        assertThat(result).hasSize(2);
        assertThat(result.get(0)).satisfies(routeDto -> {
            assertThat(routeDto.getStartAddress()).isEqualTo(routeDto.getStartAddress());
            assertThat(routeDto.getDate()).isEqualTo(routeDto.getDate());
        });

    }

    @Test
    void shouldGetRouteById() {
        // given
        UUID testId = UUID.fromString("b6f8f2d4-b556-4971-8a5b-f87e22bdb65f");
        Route testRoute1 = new Route(
                "testStart",
                "testDestination",
                10,
                TransportType.CARGO,
                10,
                LocalDate.parse("2022-05-20"));
        Mockito.when(routeRepository.findById(testId)).thenReturn(Optional.of(testRoute1));

        // when
        RouteDto result = sut.getRouteById(testId);

        // then
        assertThat(result).satisfies(routeDto -> {
            assertThat(routeDto.getStartAddress()).isEqualTo(routeDto.getStartAddress());
            assertThat(routeDto.getTransportType()).isEqualTo(routeDto.getTransportType());
            assertThat(routeDto.getDate()).isEqualTo(routeDto.getDate());
        });

    }

    @Test
    void shouldAddRoute() {
        // given
        RouteRequest testRouteRequest = new RouteRequest(
                "testStart",
                "testDestination",
                10,
                TransportType.CARGO,
                10,
                LocalDate.parse("2022-05-20"));
        Mockito.when(routeRepository.save(routeAdapter.convertRouteRequestToRoute(testRouteRequest)))
                .thenReturn(routeAdapter.convertRouteRequestToRoute(testRouteRequest));

        // when
        RouteDto result = sut.addRoute(testRouteRequest);

        // then
        assertThat(result.getStartAddress()).isEqualTo(testRouteRequest.getStartAddress());

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