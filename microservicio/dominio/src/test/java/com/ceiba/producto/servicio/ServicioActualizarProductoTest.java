package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ServicioActualizarProductoTest {

    @Test
    public void validarProductoExistencia(){
        //arrangue
        Producto producto=new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioProducto= Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(false);
        ServicioActualizarProducto servicioActualizarProducto= new ServicioActualizarProducto(repositorioProducto);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto no existe en el sistema");
    }

    @Test
    public void validarActualizacion(){
        //arrangue
        Producto producto=new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto=Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        doNothing().when(repositorioProducto).actualizar(any(Producto.class));
        ServicioActualizarProducto servicioActualizarProducto=new ServicioActualizarProducto(repositorioProducto);
        //act-assert
        servicioActualizarProducto.ejecutar(producto);
        verify(repositorioProducto,times(1)).actualizar(any(Producto.class));
    }
}
