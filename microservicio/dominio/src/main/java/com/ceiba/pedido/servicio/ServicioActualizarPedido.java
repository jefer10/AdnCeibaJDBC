package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.dto.DtoPedido;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

import java.time.LocalDateTime;


public class ServicioActualizarPedido {

    private static final String EL_USUARIO_NO_EXISTE = "El usuario no existe en el sistema";
    private static final String EL_PEDIDO_YA_SUPERO_EL_TIEMPO = "El pedido ya supero el tiempo";

    private final RepositorioPedido repositorioPedido;
    private final DaoPedido daoPedido;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido,
                                    DaoPedido daoPedido) {
        this.repositorioPedido = repositorioPedido;
        this.daoPedido=daoPedido;
    }

    public void ejecutar(Pedido pedido){///
        validarExistenciaPrevia(pedido);
        validarFecha(pedido);
        this.repositorioPedido.actualizar(pedido);
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existe(pedido.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE);
        }
    }

    private void validarFecha(Pedido pedido){
        DtoPedido pedidoOld=this.daoPedido.findById(pedido.getId());
        LocalDateTime horaDeCreacion=pedidoOld.getFecha();
        if(!LocalDateTime.now().isBefore(horaDeCreacion.plusHours(12))){
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE);
        }
    }
}
