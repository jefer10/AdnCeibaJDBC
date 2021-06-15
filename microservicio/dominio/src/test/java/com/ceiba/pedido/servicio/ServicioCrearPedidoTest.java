package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioCrearPedidoTest {

    @Test
    public void validarExistenciaPedido(){
        //arrange
        Pedido pedido=new PedidoTestDataBuilder().build();
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        Mockito.when(repositorioPedido.existe(Mockito.any())).thenReturn(true);
        ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearPedido.ejecutar(pedido), ExcepcionDuplicidad.class,"El pedido ya existe en el sistema");
    }

    @Test
    public void validarFinDeSemanaPedido(){
        LocalDateTime fecha =
                LocalDateTime.of(2021, 06, 12, 0, 0, 0, 0);
        PedidoTestDataBuilder pedidoTestDataBuilder=new PedidoTestDataBuilder().conFecha(fecha);
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        ServicioCrearPedido servicioCrearPedido=new ServicioCrearPedido(repositorioPedido);
        //act-assert
        BasePrueba.assertThrows(()->servicioCrearPedido.ejecutar(pedidoTestDataBuilder.build()), RuntimeException.class, "El pedido no puede ser creado los fines de semana");

    }
}
