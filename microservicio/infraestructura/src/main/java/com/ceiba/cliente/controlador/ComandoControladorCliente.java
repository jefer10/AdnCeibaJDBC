package com.ceiba.cliente.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.comando.manejador.ManejadorCrearCliente;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.comando.manejador.ManejadorCrearUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cliente")
@Api(tags = { "Controlador comando cliente"})
public class ComandoControladorCliente {

    private final ManejadorCrearCliente manejadorCrearCliente;

    @Autowired
    public ComandoControladorCliente(ManejadorCrearCliente manejadorCrearCliente) {
        this.manejadorCrearCliente = manejadorCrearCliente;
    }

    @PostMapping
    @ApiOperation("Crear Usuario")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoCliente comandoCliente) {
        return manejadorCrearCliente.ejecutar(comandoCliente);
    }

}
