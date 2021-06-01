package com.ceiba.producto.modelo.entidad;

import lombok.Getter;
import static com.ceiba.dominio.ValidadorArgumento.*;

@Getter
public class Producto {

    private static final String SE_DEBE_INGRESAR_EL_NOMBRE = "Se debe ingresar el  nombre";
    private static final String SE_DEBE_INGRESAR_LA_DESCRIPCION = "Se debe ingresar la descripcion del producto";
    private static final String SE_DEBE_INGRESAR_EL_VALOR_DEL_PRODUCTO = "Se debe ingresar el valor del producto";
    private static final String EL_VALOR_DEL_PRODUCTO_DEBE_SER_POSITIVO = "El valor deL producto debe ser positivo";

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public Producto(Long id, String nombre, String descripcion, Double precio) {
        validarObligatorio(nombre, SE_DEBE_INGRESAR_EL_NOMBRE);
        validarObligatorio(descripcion, SE_DEBE_INGRESAR_LA_DESCRIPCION);
        validarObligatorio(precio,SE_DEBE_INGRESAR_EL_VALOR_DEL_PRODUCTO );
        validarPositivo(precio,EL_VALOR_DEL_PRODUCTO_DEBE_SER_POSITIVO);

        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
    }
}
