package com.ceiba.producto.adaptador.dao;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProducto;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProducto implements RowMapper<DtoProducto>, MapperResult {
    @Override
    public DtoProducto mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        Double precio=rs.getDouble("precio");
        return new DtoProducto(id,nombre,descripcion,precio);
    }
}
