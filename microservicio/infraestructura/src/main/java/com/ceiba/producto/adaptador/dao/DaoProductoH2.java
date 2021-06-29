package com.ceiba.producto.adaptador.dao;


import com.ceiba.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.pedido.adaptador.dao.MapeoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.dto.DtoProductoPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DaoProductoH2 implements DaoProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace="producto", value="listar")
    private static String sqlListar;

    @SqlStatement(namespace="producto", value="productoPedido")
    private static String sqlListarPorPedido;

    @SqlStatement(namespace="producto", value="buscar")
    private static String sqlBuscar;

    public DaoProductoH2(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public List<DtoProducto> listar() {
        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListar,new MapeoProducto());
    }

    @Override
    public List<DtoProductoPedido> listarPorPedido(Long id) {
        System.out.println("<z<z<z<");
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("pedidoid", id);

        return customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlListarPorPedido,paramSource,new MapeoProductoPedido());
    }

    @Override
    public DtoProducto findById(long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        List<DtoProducto> producto=this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().query(sqlBuscar,paramSource,new MapeoProducto());
        if (producto.size()>0){
            return producto.get(0);
        }else {
            return null;
        }
    }
}
