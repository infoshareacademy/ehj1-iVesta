package pl.ergohestia.ehj1.ivesta.adapters;

import org.springframework.stereotype.Component;
import pl.ergohestia.ehj1.ivesta.request.RouteRequest;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;

@Component
public class RouteAdapter {
    DriverAdapter driverAdapter = new DriverAdapter();
    VehicleAdapter vehicleAdapter = new VehicleAdapter();

    public RouteDto convertToRouteDto(Route route) {
        if (route == null) {
            return null;
        }
        RouteDto routeDto = new RouteDto(
                route.getStartAddress(),
                route.getDestinationAddress(),
                route.getRouteLength(),
                route.getTransportType(),
                route.getTransportVolume(),
                route.getDate());
        routeDto.setId(route.getId());
        routeDto.setDriver(driverAdapter.convertToDriverDto(route.getDriver()));
        routeDto.setVehicle(vehicleAdapter.convertToVehicleDto(route.getVehicle()));
        return routeDto;
    }

    public Route convertToRoute(RouteDto routeDto) {
        if (routeDto == null) return null;
        Route route = new Route(
                routeDto.getStartAddress(),
                routeDto.getDestinationAddress(),
                routeDto.getRouteLength(),
                routeDto.getTransportType(),
                routeDto.getTransportVolume(),
                routeDto.getDate());
        route.setId(routeDto.getId());
        route.setDriver(driverAdapter.convertToDriver(routeDto.getDriver()));
        route.setVehicle(vehicleAdapter.convertToVehicle(routeDto.getVehicle()));
        return route;
    }

    public Route convertRouteRequestToRoute(RouteRequest routeRequest) {
        if (routeRequest == null) return null;
        Route route = new Route(
                routeRequest.getStartAddress(),
                routeRequest.getDestinationAddress(),
                routeRequest.getRouteLength(),
                routeRequest.getTransportType(),
                routeRequest.getTransportVolume(),
                routeRequest.getDate());
        route.setId(routeRequest.getId());
        route.setDriver(driverAdapter.convertToDriver(routeRequest.getDriver()));
        route.setVehicle(vehicleAdapter.convertToVehicle(routeRequest.getVehicle()));
        return route;
    }
}
