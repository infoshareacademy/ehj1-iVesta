package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RouteServiceTest {

    private RouteService sut = new RouteService();

    String testStartAddress = "Test Start Address";
    String testDestinationAddress = "Test Destination Address";
    Integer testRouteLength = 200;
    TransportType testTransportType = TransportType.PASSENGERS;
    Integer testTransportVolume = 20;
    RouteDto testRouteDto = prepareTestRouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);

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
        String testStartAddress = "Test Start Address";
        String testDestinationAddress = "Test Destination Address";
        Integer testRouteLength = 200;
        TransportType testTransportType = TransportType.PASSENGERS;
        Integer testTransportVolume = 20;
        RouteDto testRouteDto = prepareTestRouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);

        // when
        sut.addElement(testRouteDto);
        List<RouteDto> result = sut.getRoutes();

        // then
        assertThat(result).hasSize(1);

    }

    public RouteDto prepareTestRouteDto(String testStartAddress,
                                        String testDestinationAddress,
                                        Integer testRouteLength,
                                        TransportType testTransportType,
                                        Integer testTransportVolume) {
        return new RouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);
    }
}
