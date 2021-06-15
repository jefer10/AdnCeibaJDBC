package com.ceiba.pedidoProducto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.PedidoProducto.ComandoPedidoProducto;
import com.ceiba.pedidoProducto.contolador.ComandoControladorPedidoProducto;


import com.ceiba.pedidoProducto.serviciotestdatabuilder.ComandoPedidoProductoTestDataBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest( ComandoControladorPedidoProducto.class)
public class ComandoControlerPedidoProductoTest {


    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private MockMvc mocMvc;

    @Test
    public void crear() throws Exception{
        // arrange
        ComandoPedidoProducto pedidoProducto= new ComandoPedidoProductoTestDataBuilder().build();

        // act - assert
        mocMvc.perform(post("/pedido-producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pedidoProducto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 1}"));
    }
}
