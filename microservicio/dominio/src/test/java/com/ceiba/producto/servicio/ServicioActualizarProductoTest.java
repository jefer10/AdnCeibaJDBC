package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

public class ServicioActualizarProductoTest {

    @Test
    public void validarProductoExistencia(){
        //arrangue
        Producto producto=new ProductoTestDataBuilder().conId(1L).build();
        RepositorioProducto repositorioProducto= Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarProducto servicioActualizarProducto= new ServicioActualizarProducto(repositorioProducto);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");
    }
}
