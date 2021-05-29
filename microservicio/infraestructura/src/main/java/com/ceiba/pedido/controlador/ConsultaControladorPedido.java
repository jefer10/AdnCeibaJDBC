package com.ceiba.pedido.controlador;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.pedido.consulta.ManejadorBuscarPedido;
import com.ceiba.pedido.consulta.ManejadorListarPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.usuario.modelo.dto.DtoUsuario;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pedido")
@Api(tags={"Controlador consulta pedido"})
public class ConsultaControladorPedido {

    private final ManejadorListarPedido manejadorListarPedido;
    private final ManejadorBuscarPedido manejadorBuscarPedido;

    @Autowired
    public ConsultaControladorPedido(ManejadorListarPedido manejadorListarPedido,
                                     ManejadorBuscarPedido manejadorBuscarPedido) {
        this.manejadorListarPedido = manejadorListarPedido;
        this.manejadorBuscarPedido=manejadorBuscarPedido;
    }

    @GetMapping
    @ApiOperation("Listar pedidos")
    public List<DtoPedido> listar() {
        return this.manejadorListarPedido.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("buscar pedido")
    public DtoPedido buscasr(@PathVariable("id") long id){
        return manejadorBuscarPedido.ejecutar(id);
    }
}
