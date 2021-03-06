package com.ceiba.cliente.controlador;


import com.ceiba.ApplicationMock;
import com.ceiba.cliente.comando.ComandoCliente;
import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import com.ceiba.cliente.servicio.testdatabuilder.ComandoClienteTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;


@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorCliente.class)
public class ComandoControlerClienteTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DaoCliente daoCliente;

    @Autowired
    private MockMvc mocMvc;



        @Test
        public void crear()throws Exception{
            // arrange
            ComandoCliente comandoCliente = new ComandoClienteTestDataBuilder().conId(6L).conNombre("rrr").build();
            // act - assert
            mocMvc.perform(post("/cliente")
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(comandoCliente)))
                    .andExpect(status().isOk())
                    .andExpect(content().json("{'valor': 4}"));

           DtoCliente dtoCliente= daoCliente.findById(4);
           assertEquals(comandoCliente.getDireccion(),dtoCliente.getDireccion());
           assertEquals(comandoCliente.getNombre(),dtoCliente.getNombre());
        }


        @Test
        public void actualizar() throws Exception{
            // arrange
            Long id = 2L;
            ComandoCliente comandoCliente=new ComandoClienteTestDataBuilder().build();
            // act - assert
            mocMvc.perform(put("/cliente/{id}",id)
                    .contentType(MediaType.APPLICATION_JSON)
                    .content(objectMapper.writeValueAsString(comandoCliente)))
                    .andExpect(status().isOk());

            DtoCliente dtoCliente= daoCliente.findById(id);
            assertEquals(comandoCliente.getDireccion(),dtoCliente.getDireccion());
            assertEquals(comandoCliente.getNombre(),dtoCliente.getNombre());
        }


    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/cliente/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertNull(daoCliente.findById(id));
    }

}
