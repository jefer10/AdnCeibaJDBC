package com.ceiba.pedido.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.dominio.excepcion.ExcepcionValorInvalido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.testdatabuilder.PedidoTestDataBuilder;
import org.junit.Test;
import org.mockito.Mockito;

import java.time.LocalDateTime;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

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
    public void actualizarPedido(){
        //arrangue
        Pedido pedido=new PedidoTestDataBuilder().conId(1L).build();
        DtoPedido dtoPedido=new PedidoTestDataBuilder().conFecha(LocalDateTime.now()).dtoBuild();
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido=Mockito.mock(RepositorioPedido.class);
        Mockito.when(daoPedido.findById(anyLong())).thenReturn(dtoPedido);
        doNothing().when(repositorioPedido).actualizar(any(Pedido.class));
        Mockito.when(repositorioPedido.existe(anyLong())).thenReturn(true);
        ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido,daoPedido);
        //act-assert
        servicioActualizarPedido.ejecutar(pedido);
        verify(repositorioPedido,times(1)).actualizar(any(Pedido.class));

    }


    @Test
    public void horaDeActualizacio(){
        Pedido pedido=new PedidoTestDataBuilder().conId(1L).build();
        DtoPedido dtoPedido=new PedidoTestDataBuilder().dtoBuild();
        DaoPedido daoPedido=Mockito.mock(DaoPedido.class);
        RepositorioPedido repositorioPedido=Mockito.mock(RepositorioPedido.class);
        Mockito.when(daoPedido.findById(anyLong())).thenReturn(dtoPedido);
        doNothing().when(repositorioPedido).actualizar(any(Pedido.class));
        Mockito.when(repositorioPedido.existe(anyLong())).thenReturn(true);
        ServicioActualizarPedido servicioActualizarPedido=new ServicioActualizarPedido(repositorioPedido,daoPedido);
        //act-assert
        BasePrueba.assertThrows(()->servicioActualizarPedido.ejecutar(pedido), ExcepcionValorInvalido.class, "El pedido ya supero el tiempo");
    }



}
