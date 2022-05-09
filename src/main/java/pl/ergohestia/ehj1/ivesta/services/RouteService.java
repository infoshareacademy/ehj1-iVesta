package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.adapters.RouteAdapter;
import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.exceptions.ResourceNotFound;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.repository.RouteRepository;
import pl.ergohestia.ehj1.ivesta.request.DriverAssociation;
import pl.ergohestia.ehj1.ivesta.request.RouteRequest;
import pl.ergohestia.ehj1.ivesta.request.VehicleAssociation;

import java.util.List;
import java.util.UUID;

import static java.lang.String.format;

@Slf4j
@Service
public class RouteService {

    private final RouteRepository routeRepository;
    private final RouteAdapter routeAdapter;
    private final DriverAdapter driverAdapter;
    private final VehicleAdapter vehicleAdapter;
    private final VehicleService vehicleService;
    private final DriverService driverService;

    public RouteService(RouteRepository routeRepository, RouteAdapter routeAdapter, DriverAdapter driverAdapter, VehicleAdapter vehicleAdapter, VehicleService vehicleService, DriverService driverService) {
        this.routeRepository = routeRepository;
        this.routeAdapter = routeAdapter;
        this.driverAdapter = driverAdapter;
        this.vehicleAdapter = vehicleAdapter;
        this.vehicleService = vehicleService;
        this.driverService = driverService;
    }

    public List<RouteDto> getAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeAdapter::convertToRouteDto)
                .toList();
    }

    private Route findById(UUID id) {
        return routeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound(format("Route with id %s not found.", id)));
    }

    public RouteDto getRouteById(UUID id) {
        var route = findById(id);
        return routeAdapter.convertToRouteDto(route);
    }

    public RouteDto addRoute(RouteRequest routeRequest) {
        Route route = routeAdapter.convertRouteRequestToRoute(routeRequest);
        Route savedRoute = routeRepository.save(route);
        return routeAdapter.convertToRouteDto(savedRoute);
    }

    public void deleteRouteById(UUID id) {
        routeRepository.deleteById(id);
    }

    public RouteDto addDriverToRoute(UUID id, DriverAssociation driverAssociation) {
        Route route = findById(id);
        DriverDto driverDto = driverService.getDriverById(driverAssociation.getDriverId());
        Driver driver = driverAdapter.convertToDriver(driverDto);
        route.setDriver(driver);
        Route routeWithDriver = routeRepository.save(route);
        return routeAdapter.convertToRouteDto(routeWithDriver);
    }

    public RouteDto addVehicleToRoute(UUID id, VehicleAssociation vehicleAssociation) {
        Route route = findById(id);
        VehicleDto vehicle = vehicleService.getVehicleById(vehicleAssociation.getVehicleId());
        route.setVehicle(vehicleAdapter.convertToVehicle(vehicle));
        Route routeWithVehicle = routeRepository.save(route);
        return routeAdapter.convertToRouteDto(routeWithVehicle);
    }

    public List<RouteDto> getIncompleteRoutes(boolean withoutDriver, boolean withoutVehicle, Pageable pageable) {
        Page<Route> incompleteRoutes;
        if (withoutVehicle && !withoutDriver) {
            incompleteRoutes = routeRepository.findAllByDriverIsNotNullAndVehicleIsNull(pageable);
        } else if (!withoutVehicle && withoutDriver) {
            incompleteRoutes = routeRepository.findAllByDriverIsNullAndVehicleIsNotNull(pageable);
        } else {
            incompleteRoutes = routeRepository.findAllByDriverIsNullAndVehicleIsNull(pageable);
        }
        return incompleteRoutes
                .stream()
                .map(routeAdapter::convertToRouteDto)
                .toList();
    }
}
