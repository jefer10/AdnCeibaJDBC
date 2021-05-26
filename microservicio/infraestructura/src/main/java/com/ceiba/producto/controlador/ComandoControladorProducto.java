package com.ceiba.producto.controlador;

import com.ceiba.ComandoRespuesta;
import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.Producto.comando.manejador.ManejadorActualizarProducto;
import com.ceiba.Producto.comando.manejador.ManejadorCrearProducto;
import com.ceiba.Producto.comando.manejador.ManejadorEliminarProducto;
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
    private final ManejadorEliminarProducto manejadorEliminarProducto;

    @Autowired
    public ComandoControladorProducto(ManejadorCrearProducto manejadorCrearProducto,
                                      ManejadorActualizarProducto manejadorActualizarProducto,
                                      ManejadorEliminarProducto manejadorEliminarProducto) {
        this.manejadorCrearProducto = manejadorCrearProducto;
        this.manejadorActualizarProducto=manejadorActualizarProducto;
        this.manejadorEliminarProducto=manejadorEliminarProducto;
    }


    @PostMapping
    @ApiOperation("Crear Producto")
    public ComandoRespuesta<Long> crear(@RequestBody ComandoProducto comandoProducto) {
        return manejadorCrearProducto.ejecutar(comandoProducto);
    }

    @PutMapping(value="/{id}")
    @ApiOperation("Actualizar producto")
    public void actualizar(@RequestBody ComandoProducto comandoProducto,@PathVariable Long id) {
        comandoProducto.setId(id);
        manejadorActualizarProducto.ejecutar(comandoProducto);
    }

    @DeleteMapping(value="/{id}")
    @ApiOperation("Eliminar producto")
    public void eliminar(@PathVariable Long id) {
        manejadorEliminarProducto.ejecutar(id);
    }


}
