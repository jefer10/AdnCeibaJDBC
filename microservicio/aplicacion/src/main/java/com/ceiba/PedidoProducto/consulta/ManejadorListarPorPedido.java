package com.ceiba.PedidoProducto.consulta;

import com.ceiba.producto.modelo.dto.DtoProductoPedido;
import com.ceiba.producto.puerto.dao.DaoProducto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPorPedido {

    private final DaoProducto daoProducto;

    public ManejadorListarPorPedido(DaoProducto daoProducto) {
        this.daoProducto = daoProducto;
    }

    public List<DtoProductoPedido> ejecutar(Long id){ return this.daoProducto.listarPorPedido(id); }
}
