package com.ceiba.pedido.servicio.testdatabuilder;

import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;

import java.time.LocalDateTime;

public class PedidoTestDataBuilder {

    private Long id ;
    private LocalDateTime fecha;
    private Long clienteId;
    private Double iva;
    private Double valorEnvio;
    private Double total;


    public PedidoTestDataBuilder() {
        this.id = 1L;
        this.fecha =  LocalDateTime.of(2021, 06, 11, 0, 0, 0, 0);;
        this.clienteId = 1L;
        this.iva = 25000.0;
        this.valorEnvio = 50000.0;
        this.total = 180000.0;
    }

    public  PedidoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public  PedidoTestDataBuilder conFecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public  PedidoTestDataBuilder conClienteId(Long clienteId) {
        this.clienteId = clienteId;
        return this;
    }

    public  PedidoTestDataBuilder conIva(Double iva) {
        this.iva = iva;
        return this;
    }

    public  PedidoTestDataBuilder conValorEnvio(Double valorEnvio) {
        this.valorEnvio = valorEnvio;
        return this;
    }

    public  PedidoTestDataBuilder conTotal(Double total) {
        this.total = total;
        return this;
    }

    public Pedido build(){
        return new Pedido(id,fecha,clienteId,iva,valorEnvio,total);
    }

    public DtoPedido dtoBuild(){
        return new DtoPedido(id,fecha,clienteId,iva,valorEnvio,total);
    }

}
