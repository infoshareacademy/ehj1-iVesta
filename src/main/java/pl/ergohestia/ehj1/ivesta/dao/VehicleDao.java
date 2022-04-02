package pl.ergohestia.ehj1.ivesta.dao;

import pl.ergohestia.ehj1.ivesta.adapters.VehicleAdapter;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;
import pl.ergohestia.ehj1.ivesta.utils.HibernateUtils;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.Collection;

public class VehicleDao implements Dao<VehicleDto> {

    private final EntityManager em = HibernateUtils.getEntityManager();
    private final VehicleAdapter vehicleAdapter = new VehicleAdapter();

    @Override
    public VehicleDto find(Long id) {
        return vehicleAdapter.convertToVehicleDto(em.find(Vehicle.class, id));
    }

    @Override
    public Collection<Vehicle> findAll() {
        return em.createNamedQuery("vehicle.findAll", Vehicle.class)
                .getResultStream()
                .toList();
    }

    private void saveVehicle(Vehicle vehicle){
        em.persist(vehicle);
    }

    @Override
    @Transactional
    public void save(VehicleDto vehicleDto) {
         saveVehicle(vehicleAdapter.convertToVehicle(vehicleDto));
    }

    @Override
    public VehicleDto update(VehicleDto vehicleDto) {
        Vehicle vehicle = em.merge(vehicleAdapter.convertToVehicle(vehicleDto));
        return vehicleAdapter.convertToVehicleDto(vehicle);
    }

    @Override
    public void delete(VehicleDto vehicleDto) {
        em.remove(vehicleAdapter.convertToVehicle(vehicleDto));
    }
}
