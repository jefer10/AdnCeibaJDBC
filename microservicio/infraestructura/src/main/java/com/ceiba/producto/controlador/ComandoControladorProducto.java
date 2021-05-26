package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.Producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.Producto.comando.manejador.ManejadorCrearProducto;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.producto.modelo.dto.DtoProducto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/producto")
@Api(tags={"Controlador comando producto"})
public class ComandoControladorProducto {

    private final ManejadorCrearProducto manejadorCrearProducto;
    private final ManejadorActualizarProducto manejadorActualizarProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,
                                      ManejadorActualizarProducto manejadorActualizarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorActualizarProducto=manejadorActualizarProducto;
    }


    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }
}
