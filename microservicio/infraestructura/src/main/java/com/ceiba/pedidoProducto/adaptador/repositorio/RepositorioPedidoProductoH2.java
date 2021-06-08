package com.ceiba.pedidoProducto.adaptador.repositorio;

import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioPedidoProductoH2 implements RepositorioPedidoProducto {

    @SqlStatement(namespace = "pedido",value = "agrupar")
    private static String sqlagrupar;

    @SqlStatement(namespace = "producto",value = "eliminarPedidoProducto")
    private static String sqleliminarProductoPedido;


    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    public RepositorioPedidoProductoH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Long agrupar(PedidoProducto pedidoProducto) {
        return this.customNamedParameterJdbcTemplate.crear(pedidoProducto, sqlagrupar);
    }

    @Override
    public void eliminar(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqleliminarProductoPedido, paramSource);
    }
}
