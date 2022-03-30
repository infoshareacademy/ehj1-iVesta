package pl.ergohestia.ehj1.ivesta.adapters;

import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;

public class RouteAdapter {
    public RouteDto convertoToRouteDto(Route route) {
        if (route == null) {
            return null;
        }
        RouteDto routeDto = new RouteDto(route.getStartCity(),
                route.getStartAddress(),
                route.getDestinationCity(),
                route.getDestinationAddress(),
                route.getDriverName(),
                route.getDriverLastName(),
                route.getAssignedVehicle(),
                route.getCargoType(),
                route.getCargoWeight(),
                route.getRouteLength()
                );
        routeDto.setId(route.getId());
        return routeDto;
    }
}
