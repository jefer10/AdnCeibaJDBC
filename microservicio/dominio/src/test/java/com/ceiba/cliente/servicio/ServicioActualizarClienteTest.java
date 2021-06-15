package com.ceiba.cliente.servicio;

import com.ceiba.BasePrueba;
import com.ceiba.cliente.modelo.entidad.Cliente;
import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ClienteTestDataBuilder;
import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;


import org.junit.Test;
import org.mockito.Mockito;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.*;

public class ServicioActualizarClienteTest {

    private static final String EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA = "El usuario ya existe en el sistema";

    @Test
    public void validarClienteExistenciaPreviaTest() {
        // arrange
        Cliente cliente = new ClienteTestDataBuilder().contId(1l).build();
        RepositorioCliente repositorioCliente = Mockito.mock(RepositorioCliente.class);
        Mockito.when(repositorioCliente.existeExcluyendoId(Mockito.anyLong(),Mockito.anyString())).thenReturn(true);
        ServicioActualizarCliente servicioActualizarCliente = new ServicioActualizarCliente(repositorioCliente);
        // act - assert
        BasePrueba.assertThrows(() -> servicioActualizarCliente.ejecutar(cliente), ExcepcionDuplicidad.class,EL_CLIENTE_YA_EXISTE_EN_EL_SISTEMA);
    }

    @Test
    public void ValidarClienteTest(){
        //arrange
        Cliente cliente=new ClienteTestDataBuilder().contId(4L).build();
        RepositorioCliente repositorioCliente=Mockito.mock(RepositorioCliente.class);
        doNothing().when(repositorioCliente).actualizar(any(Cliente.class));
        ServicioActualizarCliente servicioActualizarCliente=new ServicioActualizarCliente(repositorioCliente);
        //act-assert
        servicioActualizarCliente.ejecutar(cliente);
        verify(repositorioCliente,times(1)).actualizar(any(Cliente.class));

    }


}
