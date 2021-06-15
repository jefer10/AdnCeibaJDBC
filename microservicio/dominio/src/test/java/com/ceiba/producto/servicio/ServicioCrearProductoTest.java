package com.ceiba.producto.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.producto.modelo.entidad.Producto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.testdatabuilder.ProductoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;


public class ServicioCrearProductoTest {

    @Test
    public void ValidarProducto(){
        //arrangue
        Producto producto= new ProductoTestDataBuilder().build();
        RepositorioProducto repositorioProducto= Mockito.mock(RepositorioProducto.class);
        Mockito.when(repositorioProducto.existe(Mockito.anyString())).thenReturn(true);
        ServicioCrearProducto servicioCrearProducto=new ServicioCrearProducto(repositorioProducto);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearProducto.ejecutar(producto), ExcepcionDuplicidad.class,"El producto ya existe en el sistema");

    }


}
