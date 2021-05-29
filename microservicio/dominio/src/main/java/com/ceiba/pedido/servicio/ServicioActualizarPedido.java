package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.usuario.modelo.entidad.Usuario;

public class ServicioActualizarPedido {

    private static final String EL_USUARIO_NO_EXISTE = "El usuario no existe en el sistema";

    private final RepositorioPedido repositorioPedido;

    public ServicioActualizarPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public void ejecutar(Pedido pedido){///
        validarExistenciaPrevia(pedido);
        this.repositorioPedido.actualizar(pedido);
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existe(pedido.getId());
        if(!existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_NO_EXISTE);
        }
    }
}
