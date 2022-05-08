package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import pl.ergohestia.ehj1.ivesta.model.IncompleteRouteDto;

import java.util.List;

@Repository
public class IncompleteRouteRepository {

    private final JdbcTemplate jdbcTemplate;
    private final IncompleteRouteDtoRowMapper incompleteRouteDtoRowMapper;

    public IncompleteRouteRepository(JdbcTemplate jdbcTemplate, IncompleteRouteDtoRowMapper incompleteRouteDtoRowMapper) {
        this.jdbcTemplate = jdbcTemplate;
        this.incompleteRouteDtoRowMapper = incompleteRouteDtoRowMapper;
    }

    public List<IncompleteRouteDto> getIncompleteRoutes() {
        String sql = "SELECT * FROM routes r WHERE r.driver_id IS NULL OR r.vehicle_id IS NULL";
        return jdbcTemplate.query(sql, incompleteRouteDtoRowMapper);
    }
}
