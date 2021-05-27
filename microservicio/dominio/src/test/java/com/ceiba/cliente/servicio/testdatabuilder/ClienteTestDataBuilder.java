package com.ceiba.cliente.servicio.testdatabuilder;


import com.ceiba.cliente.modelo.entidad.Cliente;

public class ClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;

    public ClienteTestDataBuilder() {
        this.id = 1L;
        this.nombre = "JEFER";
        this.direccion = "KA 23 # 32";
    }

    public ClienteTestDataBuilder contId(long id) {
        this.id=id;
        return this;
    }

    public ClienteTestDataBuilder conNombre(String nombre) {
        this.nombre=nombre;
        return this;
    }

    public ClienteTestDataBuilder conDireccion(String direccion) {
        this.direccion=direccion;
        return this;
    }

    public Cliente build(){
        return new  Cliente(id, nombre, direccion);
    }
}
