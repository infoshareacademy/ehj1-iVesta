package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.ergohestia.ehj1.ivesta.entities.Driver;
import pl.ergohestia.ehj1.ivesta.entities.Route;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Repository
public interface RouteRepository extends JpaRepository<Route, UUID> {

    List<Route> findAllByDriverNotNullAndDate(LocalDate date);

    List<Route> findAllByDriver(Driver driver);
}
