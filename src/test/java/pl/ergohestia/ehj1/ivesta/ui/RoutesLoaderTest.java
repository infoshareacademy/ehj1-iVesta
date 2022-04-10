package pl.ergohestia.ehj1.ivesta.ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.services.RouteService;
import pl.ergohestia.ehj1.ivesta.services.vehicle.VehicleService;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.Scanner;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static pl.ergohestia.ehj1.ivesta.model.TransportType.*;

@ExtendWith(MockitoExtension.class)
class RoutesLoaderTest {

    @Mock
    VehicleService vehicleService;

    @Mock
    RouteService routeService;

    @InjectMocks
    private RoutesLoader sut;

    @Test
    void shouldReturnObjectRoute() {
        // given
        String testStartAddress = "Test Start Address";
        String testDestinationAddress = "Test Destination Address";
        Integer testRouteLength = 200;
        String testCargoType = "o";
        Integer transportVolume = 200;
        InputStream testIn = prepareInputStream(
                testStartAddress,
                testDestinationAddress,
                testRouteLength,
                testCargoType,
                transportVolume);
        when(routeService.loadPositiveNumber(any())).thenReturn(200);
        when(routeService.loadTransportType(any())).thenReturn("PASSENGERS");
        when(routeService.convertToTransportType(any())).thenReturn(PASSENGERS);

        // when
        RouteDto result = sut.loadRoute(testIn);

        // then
        assertThat(result.getStartAddress()).isEqualTo(testStartAddress);
        assertThat(result.getDestinationAddress()).isEqualTo(testDestinationAddress);
        assertThat(result.getRouteLength()).isEqualTo(testRouteLength);
        assertThat(result.getTransportType()).isEqualTo(PASSENGERS);
        assertThat(result.getTransportVolume()).isEqualTo(transportVolume);
    }

    @Test
    void shouldAddVehicleToRoute() {
        // given
        RouteDto testRouteDto = prepareTestRouteDto();
        List<VehicleDto> vehicles = prepareTestVehiclesDtoCollection();
        int excpectedVehicleNo = 2;
        VehicleDto expectedVehicle = vehicles.get(excpectedVehicleNo);

        InputStream testInputStream = prepareInputStream("test", 99999, -1, excpectedVehicleNo + 1);
        Scanner testScanner = new Scanner(testInputStream);
        when(vehicleService.getVehicleDtoList()).thenReturn(vehicles);

        // when
        RouteDto result = sut.addVehicleToRoute(testScanner, testRouteDto);

        // then
        assertThat(result.getVehicle()).isEqualTo(expectedVehicle);
    }

    public RouteDto prepareTestRouteDto() {
        String testStartAddress = "Test Start Address";
        String testDestinationAddress = "Test Destination Address";
        Integer testRouteLength = 200;
        TransportType testTransportType = TransportType.PASSENGERS;
        Integer testTransportVolume = 20;
        return new RouteDto(testStartAddress, testDestinationAddress, testRouteLength, testTransportType, testTransportVolume);
    }

    public List<VehicleDto> prepareTestVehiclesDtoCollection() {
        List<VehicleDto> vehicles = List.of(
                new VehicleDto(UUID.randomUUID(), "test1", "test", "test", "test", "test", "test", 1d, 1d, 1d, 1, "test", 1d, 1d),
                new VehicleDto(UUID.randomUUID(), "test2", "test", "test", "test", "test", "test", 1d, 1d, 1d, 1, "test", 1d, 1d),
                new VehicleDto(UUID.randomUUID(), "test3", "test", "test", "test", "test", "test", 1d, 1d, 1d, 1, "test", 1d, 1d),
                new VehicleDto(UUID.randomUUID(), "test4", "test", "test", "test", "test", "test", 1d, 1d, 1d, 1, "test", 1d, 1d));
        return vehicles;
    }

    private InputStream prepareInputStream(Object... inputs) {
        StringBuilder testInput = new StringBuilder();
        for (Object input : inputs) {
            testInput.append(input).append('\n');
        }
        return new ByteArrayInputStream(testInput.toString().getBytes());
    }
}