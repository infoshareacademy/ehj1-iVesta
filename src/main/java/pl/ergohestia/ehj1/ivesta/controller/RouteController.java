package pl.ergohestia.ehj1.ivesta.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.request.DriverAssociation;
import pl.ergohestia.ehj1.ivesta.request.RouteRequest;
import pl.ergohestia.ehj1.ivesta.request.VehicleAssociation;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    public List<RouteDto> getRoutes() {
        return routeService.getAllRoutes();
    }

    @GetMapping("/{id}")
    public RouteDto getRoute(@PathVariable UUID id) {
        return routeService.getRouteById(id);
    }

    @PostMapping
    public ResponseEntity<RouteDto> addNewRoute(@RequestBody @Valid RouteRequest routeRequest) {
        return ResponseEntity.status(HttpStatus.CREATED).body(routeService.addRoute(routeRequest));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteRoute(@PathVariable UUID id) {
        try {
            routeService.deleteRouteById(id);
        }
        catch (EmptyResultDataAccessException exception) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Route not found.", exception);
        }
    }

    @PutMapping("/{id}/assignDriver")
    public RouteDto addDriverToRoute(@PathVariable UUID id, @RequestBody DriverAssociation driver) {
        return routeService.addDriverToRoute(id, driver);
    }

    @PutMapping("/{id}/assignVehicle")
    public RouteDto addVehicleToRoute(@PathVariable UUID id, @RequestBody VehicleAssociation vehicle) {
        return routeService.addVehicleToRoute(id, vehicle);
    }

    @GetMapping("/incompleteRoutes")
    public ResponseEntity<List<RouteDto>> getRoutesWithoutVehiclesOrDrivers(@RequestParam boolean withoutDriver, @RequestParam boolean withoutVehicle, Pageable pageable) {
        var incompleteRoutes = routeService.getIncompleteRoutes(withoutDriver, withoutVehicle, pageable);
        return ResponseEntity.ok(incompleteRoutes);
    }
}
