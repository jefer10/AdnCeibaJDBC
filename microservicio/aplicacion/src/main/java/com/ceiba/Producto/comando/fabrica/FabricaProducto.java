package com.ceiba.Producto.comando.fabrica;

import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.producto.modelo.entidad.Producto;
import org.springframework.stereotype.Component;

@Component
public class FabricaProducto {
    public Producto crear(ComandoProducto comandoProducto) {
        return new Producto(
                comandoProducto.getId(),
                comandoProducto.getNombre(),
                comandoProducto.getDescripcion(),
                comandoProducto.getPrecio()
        );
    }

}