package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import com.ceiba.cliente.comando.manejador.ManejadorEliminarCliente;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/cliente")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;
    private final ManejadorEliminarCliente manejadorEliminarCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente,
                                     ManejadorEliminarCliente manejadorEliminarCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
        this.manejadorEliminarCliente = manejadorEliminarCliente;
    }




    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar Usuario")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarCliente.ejecutar(id);
    }

}
