package com.ceiba.Producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.Producto.servicioTestDataBuilder.ComandoProductoTestDataBuilder;

import com.ceiba.pedido.ComandoPedido;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.serviciotestdatabuilder.ComandoPedidoTestDataBuilder;
import com.ceiba.producto.controlador.ComandoControladorProducto;
import com.ceiba.producto.modelo.dto.DtoProducto;
import com.ceiba.producto.puerto.dao.DaoProducto;

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

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorProducto.class)
public class ComandoControladorProductoTestl {
    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private DaoProducto daoProducto;

    @Autowired
    private MockMvc mocMvc;


    @Test
    public void crear()throws Exception{
        // arrange
        ComandoProducto comandoProducto = new ComandoProductoTestDataBuilder().buil();

        // act - assert
        mocMvc.perform(post("/producto")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk())
                .andExpect(content().json("{'valor': 4}"));

        DtoProducto dtoPedido=daoProducto.findById(4);
        assertEquals(comandoProducto.getNombre(),dtoPedido.getNombre());
        assertEquals(comandoProducto.getDescripcion(),dtoPedido.getDescripcion());
        assertEquals(comandoProducto.getPrecio(),dtoPedido.getPrecio());

    }

    @Test
    public void Actualizar() throws Exception{
        // arrange
        ComandoProducto comandoProducto=new ComandoProductoTestDataBuilder().conId(1L).buil();
        Long id= comandoProducto.getId();
        System.out.println(comandoProducto.getId());

        // act - assert
        mocMvc.perform(put("/producto/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(comandoProducto)))
                .andExpect(status().isOk());

        DtoProducto dtoPedido=daoProducto.findById(id);
        assertEquals(comandoProducto.getNombre(),dtoPedido.getNombre());
        assertEquals(comandoProducto.getDescripcion(),dtoPedido.getDescripcion());
        assertEquals(comandoProducto.getPrecio(),dtoPedido.getPrecio());


    }


    @Test
    public void eliminar() throws Exception {
        // arrange
        Long id = 2L;
        // act - assert
        mocMvc.perform(delete("/producto/{id}",id)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        assertNull(daoProducto.findById(id));

    }

}
