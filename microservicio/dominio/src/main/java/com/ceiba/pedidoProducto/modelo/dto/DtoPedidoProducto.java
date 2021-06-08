package com.ceiba.pedidoProducto.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class DtoPedidoProducto {

    private Long id ;
    private Long pedidoid;
    private Long productoid;
}
