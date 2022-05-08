package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ergohestia.ehj1.ivesta.model.IncompleteRouteDto;
import pl.ergohestia.ehj1.ivesta.model.RouteDto;

import java.util.List;

@Repository
public class IncompleteRouteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final IncompleteRouteDtoMapper incompleteRouteDtoMapper;

    public IncompleteRouteRepository(JdbcTemplate jdbcTemplate, IncompleteRouteDtoMapper incompleteRouteDtoMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.incompleteRouteDtoMapper = incompleteRouteDtoMapper;
    }

    public List<IncompleteRouteDto> getIncompleteRoutes() {
        String sql = "SELECT * FROM routes r WHERE r.driver_id IS NULL OR r.vehicle_id IS NULL";
        return jdbcTemplate.query(sql, incompleteRouteDtoMapper);
    }
}
