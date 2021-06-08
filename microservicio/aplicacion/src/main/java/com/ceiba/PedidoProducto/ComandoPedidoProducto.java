package com.ceiba.PedidoProducto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ComandoPedidoProducto {

    private Long id;
    private Long pedidoid;
    private Long productoid;
}
