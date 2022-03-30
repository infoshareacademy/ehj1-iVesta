package pl.ergohestia.ehj1.ivesta.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.ergohestia.ehj1.ivesta.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteService implements Service<Route> {

    // TODO remove
    private static final Logger SYSOUT = LoggerFactory.getLogger("SYSOUT");

    private final List<Route> routeList;

    public RouteService() {
        this.routeList = new ArrayList<>();
    }

    public List<Route> getRoutesList() {
        return routeList;
    }

    public void addRouteToList(Route route) {
        routeList.add(route);
    }

    //TODO implementacja metody
    @Override
    public void printElements() {
        routeList.forEach(x -> SYSOUT.info(String.valueOf(x)));
    }

    //TODO implementacja metody

    @Override
    public void addElement(Route route) {
    }



}
