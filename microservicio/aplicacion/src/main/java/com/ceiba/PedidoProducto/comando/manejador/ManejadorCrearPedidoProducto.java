package com.ceiba.PedidoProducto.comando.manejador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.PedidoProducto.ComandoPedidoProducto;
import com.ceiba.PedidoProducto.comando.fabrica.FabricaPedidoProducto;
import com.ceiba.manejador.ManejadorComandoRespuesta;
import com.ceiba.pedidoProducto.modelo.entidad.PedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioCrearPedidoProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorCrearPedidoProducto implements ManejadorComandoRespuesta<ComandoPedidoProducto, ComandoRespuesta<Long>> {

    private final FabricaPedidoProducto fabricaPedidoProducto;
    private final ServicioCrearPedidoProducto servicioCrearPedidoProducto;

    public ManejadorCrearPedidoProducto(FabricaPedidoProducto fabricaPedidoProducto, ServicioCrearPedidoProducto servicioCrearPedidoProducto) {
        this.fabricaPedidoProducto = fabricaPedidoProducto;
        this.servicioCrearPedidoProducto = servicioCrearPedidoProducto;
    }


    public ComandoRespuesta<Long> ejecutar(ComandoPedidoProducto comando) {
        PedidoProducto pedidoProducto=this.fabricaPedidoProducto.crear(comando);
        return new ComandoRespuesta<>(this.servicioCrearPedidoProducto.ejecutar(pedidoProducto));
    }
}
