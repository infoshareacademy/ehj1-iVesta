package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import pl.ergohestia.ehj1.ivesta.entities.Vehicle;
import pl.ergohestia.ehj1.ivesta.model.VehicleDto;

import java.util.List;
import java.util.UUID;

@Repository

public interface VehicleRepository extends JpaRepository<Vehicle, UUID> {

    @Query("SELECT v FROM Vehicle v WHERE v.weightLimit >= 15000")
    List<Vehicle> findAlCargoTransporters();

    @Query("SELECT v FROM Vehicle v WHERE v.numberOfSeats > 6")
    List<Vehicle> findAllBusses();
}
