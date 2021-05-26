package com.ceiba.cliente.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Cliente {
    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el  nombre";
    private static final String SE_DEBE_INGRESAR_LA_DIRECCION = "Se debe ingresar la direccion";


    private Long id;
    private String nombre;
    private String direccion;

    public Cliente(Long id, String nombre, String direccion) {
        validarObligatorio(nombre,SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(direccion,SE_DEBE_INGRESAR_LA_DIRECCION);

        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
    }
}
