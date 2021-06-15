package com.ceiba.pedidoProducto.serviciotestdatabuilder;

import com.ceiba.PedidoProducto.ComandoPedidoProducto;

public class ComandoPedidoProductoTestDataBuilder {

    private Long id ;
    private Long pedidoid;
    private Long productoid;

    public ComandoPedidoProductoTestDataBuilder() {
        this.id = 1L;
        this.pedidoid = 1L;
        this.productoid = 1L;
    }

    public ComandoPedidoProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPedidoProductoTestDataBuilder conPedidoid(Long pedidoid) {
        this.pedidoid = pedidoid;
        return this;
    }

    public ComandoPedidoProductoTestDataBuilder conProductoid(Long productoid) {
        this.productoid = productoid;
        return  this;
    }

    public ComandoPedidoProducto build(){
        return new ComandoPedidoProducto(id,pedidoid,productoid);
    }
}
