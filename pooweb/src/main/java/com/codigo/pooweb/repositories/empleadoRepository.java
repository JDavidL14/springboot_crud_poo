package com.codigo.pooweb.repositories;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import com.codigo.pooweb.model.empleado;

@Repository
public class empleadoRepository {
    
    private final NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    private final SimpleJdbcInsert insert;
    private final empleadosMapper mapper = new empleadosMapper();

    public empleadoRepository(NamedParameterJdbcTemplate namedParameterJdbcTemplate, 
                              DataSource dataSource) {
        this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
        this.insert = new SimpleJdbcInsert(dataSource)
                          .withTableName("empleados")
                          .usingGeneratedKeyColumns("codigo");
    }

    public List<empleado> getAllempleados() {
        String sql = "select * from empleados";
        return namedParameterJdbcTemplate.query(sql, mapper);
    }

    private static class empleadosMapper implements RowMapper<empleado> {
        @Override
        public empleado mapRow(ResultSet rs, int rowNum) throws SQLException {
            long codigo = rs.getLong("codigo");  // Usar long para el código
            String nombre = rs.getString("nombre");
            String estado = rs.getString("estado");

            return new empleado(codigo, nombre, estado);  // Crear objeto empleado
        }
    }

    public long createempleado(empleado newEmpleado) {
        // Insertar tanto nombre como estado
        MapSqlParameterSource params = new MapSqlParameterSource()
            .addValue("nombre", newEmpleado.nombre)
            .addValue("estado", newEmpleado.estado);  // Agregar estado

        // Ejecutar la inserción y retornar la clave generada (codigo)
        return insert.executeAndReturnKey(params).longValue();
    }
}
