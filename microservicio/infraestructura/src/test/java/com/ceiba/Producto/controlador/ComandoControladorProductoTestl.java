package com.ceiba.Producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.Producto.comando.ComandoProducto;
import com.ceiba.Producto.servicioTestDataBuilder.ComandoProductoTestDataBuilder;
import com.ceiba.producto.controlador.ComandoControladorProducto;
import com.ceiba.usuario.comando.ComandoUsuario;
import com.ceiba.usuario.servicio.testdatabuilder.ComandoUsuarioTestDataBuilder;
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
@WebMvcTest(ComandoControladorProducto.class)
public class ComandoControladorProductoTestl {
    @Autowired
    private ObjectMapper objectMapper;

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
                .andExpect(content().json("{'valor': 3}"));

    }
}
