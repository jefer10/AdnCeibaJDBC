package com.ceiba.producto.controlador;

import com.ceiba.PedidoProducto.consulta.ManejadorListarPorPedido;
import com.ceiba.Producto.consulta.ManejadorListarProductos;

import com.ceiba.producto.modelo.dto.DtoProducto;

import com.ceiba.producto.modelo.dto.DtoProductoPedido;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags={"Controlador consulta producto"})
public class ConsultaControladorProducto {

    private final ManejadorListarProductos manejadorListarProductos;
    private final ManejadorListarPorPedido manejadorListarPorPedido;

    public ConsultaControladorProducto(ManejadorListarProductos manejadorListarProductos,
                                       ManejadorListarPorPedido manejadorListarPorPedido) {
        this.manejadorListarProductos = manejadorListarProductos;
        this.manejadorListarPorPedido=manejadorListarPorPedido;
    }


    @GetMapping
    @ApiOperation("Listar productos")
    public List<DtoProducto> listar() {
        System.out.println("x");
        return manejadorListarProductos.ejecutar();
    }

    @GetMapping(value="/{id}")
    @ApiOperation("Listar productos")
    public List<DtoProductoPedido> listarPorPedido(@PathVariable("id") long id) {
        System.out.println("BVBV");
        return manejadorListarPorPedido.ejecutar(id);
    }

}
