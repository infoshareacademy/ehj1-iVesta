package pl.ergohestia.ehj1.ivesta.services;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


class RouteServiceTest {


    RouteService sut = new RouteService();

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
        String testStartAddress = "Test Start Address";
        String testDestinationAddress = "Test Destination Address";
        Integer testRouteLength = 200;
        TransportType testTransportType = TransportType.PASSENGERS;
        Integer testTransportVolume = 20;
        return new RouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);
    }


    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append(System.lineSeparator());
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}