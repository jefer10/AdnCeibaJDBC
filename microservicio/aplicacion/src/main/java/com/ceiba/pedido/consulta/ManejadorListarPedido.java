package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorListarPedido {

    private final DaoPedido daoPedido;

    public ManejadorListarPedido(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public List<DtoPedido> ejecutar(){
        return this.daoPedido.listar();
    }
}
