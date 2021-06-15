package com.ceiba.pedido.contolador;

import com.ceiba.ApplicationMock;

import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.controlador.ComandoControladorPedido;
import com.ceiba.pedido.serviciotestdatabuilder.ComandoPedidoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorPedido.class)
public class ComandoControlerPedidoTest {

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;


    @Test
    public void crear()throws Exception{
        // arrange
        ComandoPedido comandoPedido = new ComandoPedidoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/pedido")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPedido)))
                .andExpect(status().isOk());
                //.andExpect(content().json("{'valor': 1}"));



    }

    @Test
    public void Actualizar() throws Exception{
        // arrange
        ComandoPedido comandoPedido=new ComandoPedidoTestDataBuilder().conId(1L).build();
        Long id= comandoPedido.getId();
        System.out.println(comandoPedido.getId());

        // act - assert
        mocMvc.perform(put("/pedido/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoPedido)))
                .andExpect(status().isOk());

    }

    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/pedido/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

    }





}
