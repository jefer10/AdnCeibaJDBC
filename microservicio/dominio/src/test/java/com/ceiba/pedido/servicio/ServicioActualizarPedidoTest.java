package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

public class ServicioActualizarPedidoTest {

    @Test
    public void existenciaPrevia(){
        //arrangue
        Pedido pedido=new PedidoTestDataBuilder().conId(1L).build();
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);
        Mockito.when(repositorioPedido.existe(Mockito.any())).thenReturn(false);
        ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido,daoPedido);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarPedido.ejecutar(pedido), ExcepcionDuplicidad.class,"El pedido no existe en el sistema");

    }

    @Test
    public void horaDeActualizacio(){
        //arrangue
        LocalDateTime fecha =
                LocalDateTime.of(2021, 06, 14, 0, 0, 0, 0);
        DtoPedido dtoPedido=new PedidoTestDataBuilder().conFecha(fecha).dtoBuild();
        Pedido pedido=new PedidoTestDataBuilder().conFecha(fecha.plusHours(13)).build();
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido= Mockito.mock(RepositorioPedido.class);
        Mockito.when(daoPedido.findById(Mockito.anyLong())).thenReturn(dtoPedido);
        ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido,daoPedido);
        //act-assert
       // BasePrueba.assertThrows(()->servicioActualizarPedido.ejecutar(pedido), RuntimeException.class, "El pedido ya supero el tiempo");
    }



}
