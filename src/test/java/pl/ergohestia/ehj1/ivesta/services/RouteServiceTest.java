package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RouteServiceTest {

    private RouteService sut = new RouteService();

   private static final String testStartAddress = "Test Start Address";
   private static final String testDestinationAddress = "Test Destination Address";
   private static final Integer testRouteLength = 200;
   private static final TransportType testTransportType = TransportType.PASSENGERS;
   private static final Integer testTransportVolume = 20;

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

    public RouteDto prepareTestRouteDto() {
        return new RouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);
    }

    @Test
    void shouldConvertToTransportType() {
        // given
        String testInput = "o";
        String testInput2 = "t";

        // when
        TransportType result1 = sut.convertToTransportType(testInput);
        TransportType result2 = sut.convertToTransportType(testInput2);

        // then
        assertThat(result1).isEqualTo(TransportType.PASSENGERS);
        assertThat(result2).isEqualTo(TransportType.CARGO);

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
}
