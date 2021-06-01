package com.ceiba.pedido.puerto.dao;


import com.ceiba.pedido.modelo.dto.DtoPedido;

import java.util.List;

public interface DaoPedido {
    /**
     * Permite listar pedido
     * @return los pedido
     */
    List<DtoPedido> listar();

    /**
     * permite buscar un pedido por id
     * @param id identificador de pedido
     * @return pedido
     */
    DtoPedido findById(long id);
}
