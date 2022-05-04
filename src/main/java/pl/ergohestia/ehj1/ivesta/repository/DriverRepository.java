package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ergohestia.ehj1.ivesta.entities.Driver;

import java.util.UUID;

@Repository
public interface DriverRepository extends JpaRepository<Driver, UUID> {

}
