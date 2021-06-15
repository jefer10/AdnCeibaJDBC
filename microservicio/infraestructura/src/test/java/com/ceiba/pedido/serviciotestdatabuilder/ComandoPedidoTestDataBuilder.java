package com.ceiba.pedido.serviciotestdatabuilder;

import com.ceiba.pedido.ComandoPedido;

import java.time.LocalDateTime;

public class ComandoPedidoTestDataBuilder {

   private Long id ;
    private LocalDateTime fecha ;
    private Long clienteId ;
    private Double iva;
    private Double valorEnvio;
    private Double total;

    public ComandoPedidoTestDataBuilder() {
        this.id = 2L;
        this.fecha = LocalDateTime.now();
        this.clienteId = 1L;
        this.iva = 54000.0;
        this.valorEnvio = 0.0;
        this.total = 324000.0;
    }

    public ComandoPedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ComandoPedidoTestDataBuilder conClienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public ComandoPedidoTestDataBuilder conIva(Double iva) {
        this.iva = iva;
        return this;
    }

    public ComandoPedidoTestDataBuilder conValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
        return  this;
    }

    public ComandoPedidoTestDataBuilder conTotal(Double total) {
        this.total = total;
        return this;
    }

    public ComandoPedido build(){
        return new ComandoPedido(id,fecha,clienteId,iva,valorEnvio,total);
    }
}
