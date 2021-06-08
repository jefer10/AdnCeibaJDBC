package com.ceiba.PedidoProducto.comando.fabrica;

import com.ceiba.PedidoProducto.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import org.springframework.stereotype.Component;

@Component
public class FabricaPedidoProducto {

    public PedidoProducto crear(ComandoPedidoProducto comandoPedidoProducto){
        return  new PedidoProducto(comandoPedidoProducto.getId(),
                comandoPedidoProducto.getPedidoid(), comandoPedidoProducto.getProductoid());
    }
}
