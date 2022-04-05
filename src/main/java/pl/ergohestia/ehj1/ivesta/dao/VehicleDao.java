package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;

public class VehicleDao implements Dao<VehicleDto> {

    private final EntityManager em = HibernateUtils.getEntityManager();
    private final VehicleAdapter vehicleAdapter = new VehicleAdapter();

    @Override
    public VehicleDto find(Long id) {
        return vehicleAdapter.convertToVehicleDto(em.find(Vehicle.class, id));
    }

    @Override
    public Collection<VehicleDto> findAll() {
        em.getTransaction().begin();
        List<VehicleDto> vehicles = em.createNamedQuery("vehicle.findAll", Vehicle.class)
                .getResultStream()
                .map(vehicleAdapter::convertToVehicleDto)
                .toList();
        em.getTransaction().commit();
        return vehicles;

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
        em.remove(vehicleAdapter.convertToVehicle(vehicleDto));
        em.getTransaction().commit();
    }
}
