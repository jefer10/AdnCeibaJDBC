package com.ceiba.cliente.controlador;

import com.ceiba.cliente.consulta.ManejadorBuscarCliente;
import com.ceiba.cliente.consulta.ManejadorListarClientes;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.usuario.consulta.ManejadorListarUsuarios;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cliente")
@Api(tags={"Controlador comando cliente"})
public class ConsultaControladorCliente {

    private final ManejadorListarClientes manejadorListarClientes;
    private final ManejadorBuscarCliente manejadorBuscarCliente;

    public ConsultaControladorCliente(ManejadorListarClientes manejadorListarClientes,
                                      ManejadorBuscarCliente manejadorBuscarCliente) {
        this.manejadorListarClientes = manejadorListarClientes;
        this.manejadorBuscarCliente=manejadorBuscarCliente;
    }

    @GetMapping
    @ApiOperation("Listar cliente")
    public List<DtoCliente> listar() {
        return manejadorListarClientes.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("buscar cliente")
    public DtoCliente buscasr(@PathVariable("id") long id){
        return manejadorBuscarCliente.ejecutar(id);
    }
}
