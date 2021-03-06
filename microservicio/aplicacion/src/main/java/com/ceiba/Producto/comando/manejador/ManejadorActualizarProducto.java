package com.ceiba.Producto.comando.manejador;

import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.Producto.comando.fabrica.FabricaProducto;
import com.ceiba.manejador.ManejadorComando;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import org.springframework.stereotype.Component;

@Component
public class ManejadorActualizarProducto implements ManejadorComando<ComandoProducto> {

    private final FabricaProducto fabricaProducto;
    private final ServicioActualizarProducto servicioActualizarProducto;

    public ManejadorActualizarProducto(FabricaProducto fabricaProducto,
                                       ServicioActualizarProducto servicioActualizarProducto) {
        this.fabricaProducto = fabricaProducto;
        this.servicioActualizarProducto = servicioActualizarProducto;
    }

    @Override
    public void ejecutar(ComandoProducto comandoProducto) {
        Producto producto=this.fabricaProducto.crear(comandoProducto);
        this.servicioActualizarProducto.ejecutar(producto);
    }
}
