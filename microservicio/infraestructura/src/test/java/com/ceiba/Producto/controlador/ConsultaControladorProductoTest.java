package com.ceiba.Producto.controlador;

import com.ceiba.ApplicationMock;
import com.ceiba.producto.controlador.ComandoControladorProducto;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes= ApplicationMock.class)
@WebMvcTest(ComandoControladorProducto.class)
public class ConsultaControladorProductoTest {
}
