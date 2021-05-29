package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

public class ServicioCrearPedido {

    private static final String EL_USUARIO_YA_EXISTE = "El usuario ya existe en el sistema";

    private final RepositorioPedido repositorioPedido;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido){///
        validarExistenciaPrevia(pedido);
        return this.repositorioPedido.crear(pedido);
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existe(pedido.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE);
        }
    }
}
