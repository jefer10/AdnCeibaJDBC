package com.ceiba.pedido.servicio;

import com.ceiba.dominio.excepcion.ExcepcionDuplicidad;
import com.ceiba.pedido.modelo.entidad.Pedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;

import java.time.DayOfWeek;

public class ServicioCrearPedido {

    private static final String EL_USUARIO_YA_EXISTE = "El usuario ya existe en el sistema";
    private static final String NO_SE_PUEDE_PEDIR_PEDIDO_LOS_FINES_DE_SEMANA = "El pedido no puede ser creado los fines de semana";

    private final RepositorioPedido repositorioPedido;

    public ServicioCrearPedido(RepositorioPedido repositorioPedido) {
        this.repositorioPedido = repositorioPedido;
    }

    public Long ejecutar(Pedido pedido){///
        validarExistenciaPrevia(pedido);
        validarFinDeSemana(pedido);
        return this.repositorioPedido.crear(pedido);
    }

    private void validarExistenciaPrevia(Pedido pedido) {
        boolean existe = this.repositorioPedido.existe(pedido.getId());
        if(existe) {
            throw new ExcepcionDuplicidad(EL_USUARIO_YA_EXISTE);
        }
    }

    private void validarFinDeSemana(Pedido pedido){
        if ((pedido.getFecha().getDayOfWeek()== DayOfWeek.SUNDAY)
                && (pedido.getFecha().getDayOfWeek()==DayOfWeek.SATURDAY)){
            throw new ExcepcionDuplicidad(NO_SE_PUEDE_PEDIR_PEDIDO_LOS_FINES_DE_SEMANA);
        }
    }

}
