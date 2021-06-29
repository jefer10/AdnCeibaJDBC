package com.ceiba.pedido.adaptador.dao;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class DaoPedidoH2 implements DaoPedido {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="pedido", value="listar")
    private static String sqlListar;
    @SqlStatement(namespace = "pedido" ,value="buscar")
    private static String sqlBusqueda;

    public DaoPedidoH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }


    @Override
    public List<DtoPedido> listar() {
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoPedido());
    }

    @Override
    public DtoPedido findById(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoPedido> pedido=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBusqueda,paramSource,new MapeoPedido());
        if (pedido.size()>0){
            return pedido.get(0);
        }else {
            return null;
        }
    }
}
