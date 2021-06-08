package com.ceiba.pedidoProducto.modelo.entidad;

import lombok.Getter;

import static com.ceiba.dominio.ValidadorArgumento.validarObligatorio;

@Getter
public class PedidoProducto {

    private static final String SE_DEBE_INGRESAR_ID_PRODUCTO = "Se debe ingresar el  id del producto";
    private static final String SE_DEBE_INGRESAR_ID_PEDIDO = "Se debe ingresar el id del pedido";

    private Long id;
    private Long pedidoid;
    private Long productoid;

    public PedidoProducto(Long id, Long pedidoid, Long productoid) {
        validarObligatorio(pedidoid, SE_DEBE_INGRESAR_ID_PEDIDO);
        validarObligatorio(productoid,SE_DEBE_INGRESAR_ID_PRODUCTO);
        this.id = id;
        this.pedidoid = pedidoid;
        this.productoid = productoid;
    }
}
