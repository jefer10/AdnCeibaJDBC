package com.ceiba.producto.puerto.dao;

import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.modelo.dto.DtoProductoPedido;

import java.util.List;

public interface DaoProducto {
    /**
     * Permite listar producto
     * @return los usuarios
     */
    List<DtoProducto> listar();

    /**
     * permite listar los productos por pedido
     * @return los productos del pedido
     */
    List<DtoProductoPedido>listarPorPedido(Long id);
}
