package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Collection;

public class DriverDao implements Dao<DriverDto>{
    private final EntityManager em = HibernateUtils.getEntityManager();
    private final DriverAdapter adapter = new DriverAdapter();

    @Override
    public DriverDto find(Long id) {
        return null;
    }

    @Override
    public Collection<Vehicle> findAll() {
        return null;
    }

    public void save(DriverDto driverDto) {
        saveDriver(adapter.convertToDriver(driverDto));
    }

    @Override
    public DriverDto update(DriverDto driverDto) {
        return null;
    }

    @Override
    public void delete(DriverDto driverDto) {

    }

    private Driver saveDriver(Driver driver) {
        em.persist(driver);
        return driver;
    }
}
