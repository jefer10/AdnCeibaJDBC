package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Api(tags={"Controlador comando cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;

    public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes) {
        this.manejadorListarClientes = manejadorListarClientes;
    }

    @GetMapping
    @ApiOperation("Listar Usuarios")
    public List<DtoCliente> listar() {
        return manejadorListarClientes.ejecutar();
    }
}
