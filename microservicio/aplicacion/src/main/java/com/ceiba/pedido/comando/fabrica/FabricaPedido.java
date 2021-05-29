package com.ceiba.pedido.comando.fabrica;


import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class FabricaPedido {

    public Pedido crear(ComandoPedido comandoPedido) {
        return new Pedido(
                comandoPedido.getId(),
                comandoPedido.getFecha(),
                comandoPedido.getClienteId(),
                comandoPedido.getIva(),
                comandoPedido.getValorEnvio(),
                comandoPedido.getTotal()
        );
    }


}
