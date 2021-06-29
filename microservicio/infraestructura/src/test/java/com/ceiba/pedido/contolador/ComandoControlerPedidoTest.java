package com.ceiba.pedido.contolador;

import com.ceiba.ApplicationMock;

import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.controlador.ComandoControladorPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
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

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.*;
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
    private DaoPedido daoPedido;

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
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 2}"));

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        DtoPedido dtoPedido=daoPedido.findById(2);
        assertEquals(comandoPedido.getClienteId(),dtoPedido.getClienteId());
        assertEquals(comandoPedido.getFecha().format(f),dtoPedido.getFecha().format(f));
        assertEquals(comandoPedido.getIva(),dtoPedido.getIva());
        assertEquals(comandoPedido.getValorEnvio(),dtoPedido.getValorEnvio());
        assertEquals(comandoPedido.getTotal(),dtoPedido.getTotal());


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

        DateTimeFormatter f = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH:mm:ss");
        DtoPedido dtoPedido=daoPedido.findById(id);
        assertEquals(comandoPedido.getClienteId(),dtoPedido.getClienteId());
        assertEquals(comandoPedido.getFecha().format(f),dtoPedido.getFecha().format(f));
        assertEquals(comandoPedido.getIva(),dtoPedido.getIva());
        assertEquals(comandoPedido.getValorEnvio(),dtoPedido.getValorEnvio());
        assertEquals(comandoPedido.getTotal(),dtoPedido.getTotal());


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

        assertNull(daoPedido.findById(id));

    }





}
