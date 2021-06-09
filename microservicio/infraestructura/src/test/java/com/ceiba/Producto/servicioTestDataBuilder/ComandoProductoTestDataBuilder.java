package com.ceiba.Producto.servicioTestDataBuilder;

import com.ceiba.Producto.comando.ComandoProducto;

public class ComandoProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public ComandoProductoTestDataBuilder() {
        this.id = 1l;
        this.nombre ="tarito rojo";
        this.descripcion = "vitaminas";
        this.precio = 25000.0;
    }

    public ComandoProductoTestDataBuilder  conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ComandoProductoTestDataBuilder  conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ComandoProductoTestDataBuilder  conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }

    public ComandoProducto buil(){
        return new ComandoProducto(id,nombre,descripcion,precio);
    }
}