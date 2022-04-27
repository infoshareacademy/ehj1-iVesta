/*
package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.DriverAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.model.DriverDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class DriverDao implements Dao<DriverDto> {
    private final EntityManager em = HibernateUtils.getEntityManager();
    private final DriverAdapter adapter = new DriverAdapter();

    private void saveDriver(Driver driver) {
        em.getTransaction().begin();
        em.persist(driver);
        em.getTransaction().commit();
    }

    public void save(DriverDto driverDto) {
        saveDriver(adapter.convertToDriver(driverDto));
    }

    @Override
    public DriverDto find(UUID id) {
        return adapter.convertToDriverDto(em.find(Driver.class, id));
    }

    @Override
    public Collection<DriverDto> findAll() {
        em.getTransaction().begin();
        List<DriverDto> drivers = em.createNamedQuery("drivers.findAll", Driver.class)
                .getResultStream()
                .map(adapter::convertToDriverDto)
                .toList();
        em.getTransaction().commit();
        return drivers;
    }

    @Override
    public DriverDto update(DriverDto driverDto) {
        em.getTransaction().begin();
        Driver driver = em.merge(adapter.convertToDriver(driverDto));
        em.getTransaction().commit();
        return adapter.convertToDriverDto(driver);
    }

    @Override
    public void delete(DriverDto driverDto) {
        em.getTransaction().begin();
        em.remove(adapter.convertToDriver(driverDto));
        em.getTransaction().commit();
    }

    public List<DriverDto> findByDate(LocalDate date) {
        em.getTransaction().begin();
        List<DriverDto> result = em.createNamedQuery("drivers.availableForCurrentDate", Driver.class)
                .setParameter("date", date)
                .getResultStream()
                .map(adapter::convertToDriverDto)
                .toList();
        em.getTransaction().commit();
        return result;
    }
}
*/
