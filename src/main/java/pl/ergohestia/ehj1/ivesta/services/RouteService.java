package pl.ergohestia.ehj1.ivesta.services;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.dao.RouteDao;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

@Slf4j
public class RouteService implements Service<RouteDto> {

    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private Collection<RouteDto> routeList;
    private RouteDao routeDao = new RouteDao();

    public RouteService() {
        this.routeList = new ArrayList<>();
    }

    public Collection<RouteDto> getRoutes() {
        return routeDao.findAll();
    }

    public TransportType convertToTransportType(String input) {
        return switch (input) {
            case "o" -> TransportType.PASSENGERS;
            case "t" -> TransportType.CARGO;
            default -> throw new IllegalStateException("Unexpected value: " + input);
        };
    }

    @Override
    public void printElements() {
        routeList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    @Override
    public void addElement(RouteDto routeDto) {
        routeList.add(routeDto);
    }

    public void saveRoute(RouteDto routeDto) {
        routeDao.save(routeDto);
    }
}

