package com.ceiba.pedido;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedido {

    private Long id ;
    private LocalDateTime fecha;
    private Long clienteId;
    private Double iva;
    private Double valorEnvio;
    private Double total;
}
