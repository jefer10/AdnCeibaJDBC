package com.ceiba.pedidoProducto.puerto.repositorio;

import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;

public interface RepositorioPedidoProducto {

    /**
     * permite agrupar el pedido con los productos
     * @param pedidoProducto
     */
    Long agrupar(PedidoProducto pedidoProducto);

    /**
     * permite eliminar la relacion
     * @param id
     * @return
     */
    void eliminar(Long id);

}
