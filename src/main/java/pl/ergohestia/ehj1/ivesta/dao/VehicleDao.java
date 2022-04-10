package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import java.util.Collection;
import java.util.UUID;

public class VehicleDao implements Dao<VehicleDto> {

    private EntityManager em = HibernateUtils.getEntityManager();
    private VehicleAdapter vehicleAdapter = new VehicleAdapter();

    @Override
    public VehicleDto find(UUID id) {
        em.getTransaction().begin();
        Vehicle vehicle = findVehicle(id);
        em.getTransaction().commit();
        return vehicleAdapter.convertToVehicleDto(vehicle);
    }

    private Vehicle findVehicle(UUID id) {
        return em.find(Vehicle.class, id);
    }

    @Override
    public Collection<VehicleDto> findAll() {
        em.getTransaction().begin();
        Collection<VehicleDto> vehiclesDto = em.createNamedQuery("vehicle.findAll", Vehicle.class)
                .getResultStream()
                .map(vehicleAdapter::convertToVehicleDto)
                .toList();
        em.getTransaction().commit();
        return vehiclesDto;

    }

    private void saveVehicle(Vehicle vehicle){
        em.getTransaction().begin();
        em.persist(vehicle);
        em.getTransaction().commit();
    }

    @Override
    public void save(VehicleDto vehicleDto) {
        saveVehicle(vehicleAdapter.convertToVehicle(vehicleDto));
    }

    @Override
    public VehicleDto update(VehicleDto vehicleDto) {
        em.getTransaction().begin();
        Vehicle vehicle = em.merge(vehicleAdapter.convertToVehicle(vehicleDto));
        em.getTransaction().commit();
        return vehicleAdapter.convertToVehicleDto(vehicle);
    }

    @Override
    public void delete(VehicleDto vehicleDto) {
        em.getTransaction().begin();
        em.remove(findVehicle(vehicleDto.getId()));
        em.getTransaction().commit();
    }
}
