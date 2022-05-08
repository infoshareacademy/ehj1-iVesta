package pl.ergohestia.ehj1.ivesta.repository;

import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import pl.ergohestia.ehj1.ivesta.model.IncompleteRouteDto;
import pl.ergohestia.ehj1.ivesta.model.TransportType;

import java.sql.ResultSet;
import java.sql.SQLException;

@Service
public class IncompleteRouteDtoRowMapper implements RowMapper<IncompleteRouteDto> {

    @Override
    public IncompleteRouteDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new IncompleteRouteDto(
                rs.getString("start_address"),
                rs.getString("destination_address"),
                rs.getInt("route_length"),
                TransportType.valueOf(rs.getString("transport_type")),
                rs.getInt("transport_volume"),
                rs.getDate("date").toLocalDate(),
                rs.getString("vehicle_id"),
                rs.getString("driver_id")
        );
    }
}
