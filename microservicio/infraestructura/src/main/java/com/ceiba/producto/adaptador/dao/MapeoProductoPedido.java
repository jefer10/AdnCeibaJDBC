package com.ceiba.producto.adaptador.dao;

import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.producto.modelo.dto.DtoProductoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class MapeoProductoPedido implements RowMapper<DtoProductoPedido>, MapperResult {

    @Override
    public DtoProductoPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
         Long pid=rs.getLong("pid");
         Long id=rs.getLong("id");
         String nombre=rs.getString("nombre");
         String descripcion=rs.getString("descripcion");
         Double precio=rs.getDouble("precio");
        return new DtoProductoPedido(pid,id,nombre,descripcion,precio);
    }
}
