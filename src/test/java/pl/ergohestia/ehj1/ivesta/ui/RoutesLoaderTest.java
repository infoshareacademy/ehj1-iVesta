package pl.ergohestia.ehj1.ivesta.ui;

import org.junit.jupiter.api.Test;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.assertj.core.api.Assertions.assertThat;
import static pl.ergohestia.ehj1.ivesta.model.TransportType.*;

class RoutesLoaderTest {

    private RoutesLoader sut = new RoutesLoader();

    @Test
    void shouldReturnObjectRoute() {
        // given
        String testStartAddress = "Test Start Address";
        String testDestinationAddress = "Test Destination Address";
        Integer testRouteLength = 200;
        String testCargoType = "o";
        Integer transportVolume = 20;
        InputStream testIn = prepareInputStream(
                testStartAddress,
                testDestinationAddress,
                testRouteLength,
                testCargoType,
                transportVolume);

        // when
        RouteDto result = sut.loadRoute(testIn);

        // then
        assertThat(result.getStartAddress()).isEqualTo(testStartAddress);
        assertThat(result.getDestinationAddress()).isEqualTo(testDestinationAddress);
        assertThat(result.getRouteLength()).isEqualTo(testRouteLength);
        assertThat(result.getTransportType()).isEqualTo(PASSENGERS);
        assertThat(result.getTransportVolume()).isEqualTo(transportVolume);
    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append('\n');
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}