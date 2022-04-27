package pl.ergohestia.ehj1.ivesta.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.services.RouteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/routes")
public class RouteController {

    private final RouteService routeService;

    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @GetMapping
    List<RouteDto> getRoutes(){
        throw new RuntimeException();
    }

    @GetMapping("/{id}")
    ResponseEntity<RouteDto> getRoute(@PathVariable UUID id){
        throw new RuntimeException();
    }

    @PostMapping
    ResponseEntity<RouteDto> addNewRoute(@RequestBody RouteDto routeDto
    ){
        throw new RuntimeException();
    }

    @DeleteMapping("/{id}")
    ResponseEntity<?> deleteRoute(@PathVariable UUID id){
        throw new RuntimeException();
    }

    @PutMapping("/{id}/assignDriver")
    ResponseEntity<RouteDto> addDriverToRoute(@PathVariable UUID id, @RequestBody DriverDto driverDto){
        throw new RuntimeException();
    }

    @PutMapping("/{id}/assignVehicle")
    ResponseEntity<RouteDto> addVehicleToRoute(@PathVariable UUID id, @RequestBody Vehicle vehicle){
        throw new RuntimeException();
    }
}
