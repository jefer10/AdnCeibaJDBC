package com.ceiba.pedido.modelo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@AllArgsConstructor
public class DtoPedido {

    private Long id ;
    private LocalDateTime fecha;
    private Long clienteId;
    private Double iva;
    private Double valorEnvio;
    private Double total;
}
