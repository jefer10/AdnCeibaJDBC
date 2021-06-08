package com.ceiba.pedidoProducto.contolador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.PedidoProducto.ComandoPedidoProducto;
import com.ceiba.PedidoProducto.comando.manejador.ManejadorCrearPedidoProducto;
import com.ceiba.PedidoProducto.comando.manejador.ManejadorEliminarPedidoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido-producto")
@Api(tags={"Controlador comando pedido-producto"})
public class ComandoControladorPedidoProducto {

    private final ManejadorCrearPedidoProducto manejadorCrearPedidoProducto;
    private final ManejadorEliminarPedidoProducto manejadorEliminarPedidoProducto;

    @Autowired
    public ComandoControladorPedidoProducto(ManejadorCrearPedidoProducto manejadorCrearPedidoProducto,
                                            ManejadorEliminarPedidoProducto manejadorEliminarPedidoProducto) {
        this.manejadorCrearPedidoProducto = manejadorCrearPedidoProducto;
        this.manejadorEliminarPedidoProducto=manejadorEliminarPedidoProducto;
    }

    @PostMapping
    @ApiOperation("Crear enlace entre pedido y producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPedidoProducto comandoPedidoProducto) {
        System.out.println(comandoPedidoProducto.getPedidoid());
        System.out.println(comandoPedidoProducto.getProductoid());
        return manejadorCrearPedidoProducto.ejecutar(comandoPedidoProducto);
    }


    @DeleteMapping(value = "/{id}")
    @ApiOperation("elimina enlace entre pedido y producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPedidoProducto.ejecutar(id);
    }
}
