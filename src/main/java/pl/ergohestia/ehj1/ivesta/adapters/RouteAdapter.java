package pl.ergohestia.ehj1.ivesta.adapters;

import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;

public class RouteAdapter {
    public RouteDto convertToRouteDto(Route route) {
        if (route == null) {
            return null;
        }
        RouteDto routeDto = new RouteDto(
                route.getStartAddress(),
                route.getDestinationAddress(),
                route.getRouteLength(),
                route.getTransportType(),
                route.getTransportVolume());
        routeDto.setId(route.getId());
        return routeDto;
    }

    public Route convertToRoute(RouteDto routeDto) {
        if (routeDto == null) return null;
        Route route = new Route(
                routeDto.getStartAddress(),
                routeDto.getDestinationAddress(),
                routeDto.getRouteLength(),
                routeDto.getTransportType(),
                routeDto.getTransportVolume());
                routeDto.setId(routeDto.getId());
        return route;
    }
}
