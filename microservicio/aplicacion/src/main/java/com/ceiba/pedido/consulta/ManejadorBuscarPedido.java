package com.ceiba.pedido.consulta;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import org.springframework.stereotype.Component;

@Component
public class ManejadorBuscarPedido {

    private final DaoPedido daoPedido;

    public ManejadorBuscarPedido(DaoPedido daoPedido) {
        this.daoPedido = daoPedido;
    }

    public DtoPedido ejecutar(long id){
        return this.daoPedido.findById(id);
    }
}
