package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static pl.ergohestia.ehj1.ivesta.utils.HibernateUtils.em;

class RouteServiceTest {

    @BeforeEach
    void setUp() {
        em.getTransaction().begin();
    }

    @AfterEach
    void tearDown() {
        em.getTransaction().rollback();
    }

    private final RouteService sut = new RouteService();

    @Test
    void shouldGetEmptyList() {
        // given

        // when
        List<RouteDto> result = sut.getRoutes();

        // then
        assertThat(result).isEmpty();
    }

    @Test
    void shouldAddElement() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();

        // when
        sut.addElement(testRouteDto);
        List<RouteDto> result = sut.getRoutes();

        // then
        assertThat(result).hasSize(1);

    }

    @Test
    void shouldConvertToPassengers() {
        // given
        String testInput = "o";

        // when
        TransportType result1 = sut.convertToTransportType(testInput);

        // then
        assertThat(result1).isEqualTo(TransportType.PASSENGERS);

    }

    @Test
    void shouldConvertToCargo() {
        // given
        String testInput = "t";

        // when
        TransportType result = sut.convertToTransportType(testInput);

        // then
        assertThat(result).isEqualTo(TransportType.CARGO);

    }

    @Test
    void shouldThrowExceptionWhenInputIsNotOOrT() {
        // given
        String testWrongInput = "x";

        // when
        Exception exception = assertThrows(Exception.class, () -> sut.convertToTransportType(testWrongInput));

        // then
        assertThat(exception).isInstanceOf(IllegalStateException.class);
        assertThat(exception.getMessage()).contains("Unexpected value:");
    }

    public RouteDto prepareTestRouteDto() {
        return new RouteDto("Test Start Address",
                "Test Destination Address",
                200,
                TransportType.PASSENGERS,
                20,
                LocalDate.parse("2022-04-20"));
    }
}
