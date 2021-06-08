package com.ceiba.PedidoProducto.comando.manejador;

import com.ceiba.manejador.ManejadorComando;
import com.ceiba.pedidoProducto.servicio.ServicioEliminarPedidoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorEliminarPedidoProducto implements ManejadorComando<Long> {

    private final ServicioEliminarPedidoProducto servicioEliminarPedidoProducto;

    public ManejadorEliminarPedidoProducto(ServicioEliminarPedidoProducto servicioEliminarPedidoProducto) {
        this.servicioEliminarPedidoProducto = servicioEliminarPedidoProducto;
    }

    @Override
    public void ejecutar(Long idPedidoProducto) {
        this.servicioEliminarPedidoProducto.ejecutar(idPedidoProducto);
    }
}
