package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.RouteAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Route;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class RouteDao implements Dao<RouteDto> {

    private final EntityManager em = HibernateUtils.getEntityManager();
    private final RouteAdapter routeAdapter = new RouteAdapter();

    @Override
    public RouteDto find(UUID id) {
        return routeAdapter.convertToRouteDto(em.find(Route.class, id));
    }

    @Override
    public Collection<RouteDto> findAll() {
        em.getTransaction().begin();
        List<RouteDto> routes = em.createNamedQuery("route.findAll", Route.class)
                .getResultStream()
                .map(routeAdapter::convertToRouteDto)
                .toList();
        em.getTransaction().commit();
        return routes;
    }

    private void saveRoute(Route route){
        em.getTransaction().begin();
        em.persist(route);
        em.getTransaction().commit();
    }

    @Override
    public void save(RouteDto routeDto) {
        saveRoute(routeAdapter.convertToRoute(routeDto));
    }

    @Override
    public RouteDto update(RouteDto routeDto) {
        em.getTransaction().begin();
        Route route = em.merge(routeAdapter.convertToRoute(routeDto));
        em.getTransaction().commit();
        return routeAdapter.convertToRouteDto(route);
    }

    @Override
    public void delete(RouteDto routeDto) {
        em.getTransaction().begin();
        em.remove(routeAdapter.convertToRoute(routeDto));
        em.getTransaction().commit();
    }
    public RouteDto updateDriver(UUID routeId, Driver driver){
        em.getTransaction().begin();
        Route route = (em.find(Route.class, routeId));
        route.setDriver(driver);
        em.merge(route);
        em.getTransaction().commit();
        return (routeAdapter.convertToRouteDto(route));
    }
}
