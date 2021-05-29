package com.ceiba.pedido.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.comando.fabrica.FabricaPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarPedido implements ManejadorComando<ComandoPedido> {

    private final FabricaPedido fabricaPedido;
    private final ServicioActualizarPedido actualizarPedido;

    public ManejadorActualizarPedido(FabricaPedido fabricaPedido,
                                     ServicioActualizarPedido actualizarPedido) {
        this.fabricaPedido = fabricaPedido;
        this.actualizarPedido = actualizarPedido;
    }

    @Override
    public void ejecutar(ComandoPedido comando) {
        Pedido pedido =this.fabricaPedido.crear(comando);
        this.actualizarPedido.ejecutar(pedido);
    }
}
