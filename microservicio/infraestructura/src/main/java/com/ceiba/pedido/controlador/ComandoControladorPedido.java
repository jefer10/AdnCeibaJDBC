package com.ceiba.pedido.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.comando.manejador.ManejadorActualizarPedido;
import com.ceiba.pedido.comando.manejador.ManejadorCrearPedido;
import com.ceiba.pedido.comando.manejador.ManejadorEliminarPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedido")
@Api(tags={"Controlador comando pedido"})
public class ComandoControladorPedido {

    private final ManejadorActualizarPedido manejadorActualizarPedido;
    private final ManejadorCrearPedido manejadorCrearPedido;
    private  final ManejadorEliminarPedido manejadorEliminarPedido;

    @Autowired
    public ComandoControladorPedido(ManejadorActualizarPedido manejadorActualizarPedido,
                                    ManejadorCrearPedido manejadorCrearPedido,
                                    ManejadorEliminarPedido manejadorEliminarPedido) {
        this.manejadorActualizarPedido = manejadorActualizarPedido;
        this.manejadorCrearPedido = manejadorCrearPedido;
        this.manejadorEliminarPedido = manejadorEliminarPedido;
    }

    @PostMapping
    @ApiOperation("Crear pedido")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoPedido comandoPedido) {
        System.out.println(comandoPedido.getFecha());
        System.out.println(comandoPedido.getValorEnvio());
        return manejadorCrearPedido.ejecutar(comandoPedido);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarPedido.ejecutar(id);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar Usuario")
    public void actualizar(@RequestBody ComandoPedido comandoPedido,@PathVariable Long id) {
        comandoPedido.setId(id);
        manejadorActualizarPedido.ejecutar(comandoPedido);
    }
}
