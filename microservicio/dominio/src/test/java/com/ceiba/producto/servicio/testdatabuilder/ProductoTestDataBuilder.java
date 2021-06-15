package com.ceiba.producto.servicio.testdatabuilder;

import com.ceiba.producto.modelo.entidad.Producto;

public class ProductoTestDataBuilder {

    private Long id;
    private String nombre;
    private String descripcion;
    private Double precio;

    public ProductoTestDataBuilder(){
        id=8L;
        nombre="camisa azul";
        descripcion="talla s camisa color azul";
        precio=50000.0;
    }

    public ProductoTestDataBuilder conId(Long id) {
        this.id = id;
        return this;
    }

    public ProductoTestDataBuilder conNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public ProductoTestDataBuilder conDescripcion(String descripcion) {
        this.descripcion = descripcion;
        return this;
    }

    public ProductoTestDataBuilder conPrecio(Double precio) {
        this.precio = precio;
        return this;
    }
    public Producto build(){
        return new Producto(id,nombre,descripcion,precio);
    }
}
