package com.ceiba.cliente.servicio;

import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionValorObligatorio;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import com.ceiba.BasePrueba;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;




public class ServicioCrearClienteTest {
/*
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el  nombre";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";

    @Mock
    private RepositorioCliente repositorioCliente;

    @Test
    public void validarNombreRequeridoTest(){
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder=new ClienteTestDataBuilder().conNombre(null);
        // act - assert
        BasePrueba.assertThrows(() ->clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
                SE_DEBE_INGRESAR_EL_NOMBRE);
    }

    @Test
    public void validarDireccionRequeridaTest(){
        // arrange
        ClienteTestDataBuilder clienteTestDataBuilder=new ClienteTestDataBuilder().conDireccion(null);
        // act - assert
        BasePrueba.assertThrows(() ->clienteTestDataBuilder.build(), ExcepcionValorObligatorio.class,
                SE_DEBE_INGRESAR_LA_DIRECCION);
    }

    @Test
    public void validarClienteExistenciaPreviaTest(){
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente=Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existe(Mockito.anyString()) ).thenReturn(false);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(1l);
        ServicioCrearCliente servicioCrearCliente=new ServicioCrearCliente(repositorioCliente);
        // act - assert
        assertEquals (1L, servicioCrearCliente.ejecutar(cliente).longValue() );
    }

    @Test
    public void validarCrearClienteTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().build();
        RepositorioCliente repositorioCliente=Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.crear(cliente)).thenReturn(1L);
        ServicioCrearCliente servicioCrearCliente=new ServicioCrearCliente(repositorioCliente);
        // act - assert
        servicioCrearCliente.ejecutar(cliente);
        verify(repositorioCliente, times(1)).crear(cliente);//verifica que se llame la dependencia repositorioCliente y llame al metodo crear
    }
*/
}
