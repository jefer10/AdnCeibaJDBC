package com.ceiba.pedido.adaptador.dao;


import com.ceiba.infraestructura.jdbc.MapperResult;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

public class MapeoPedido implements RowMapper<DtoPedido>, MapperResult {

    @Override
    public DtoPedido mapRow(ResultSet rs, int rowNum) throws SQLException {
        Long id = rs.getLong("id");
        LocalDateTime fecha = extraerLocalDateTime(rs,"fecha");
        Long clienteId = rs.getLong("clienteid");
        Double iva=rs.getDouble("iva");
        Double valorEnvio=rs.getDouble("valorEnvio");
        Double total=rs.getDouble("total");
        return new DtoPedido(id,fecha,clienteId,iva,valorEnvio,total);
    }



}
