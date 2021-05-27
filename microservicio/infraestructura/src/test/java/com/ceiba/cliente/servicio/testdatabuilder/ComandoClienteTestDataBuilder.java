package com.ceiba.cliente.servicio.testdatabuilder;

import com.ceiba.cliente.comando.ComandoCliente;

import java.util.Random;

public class ComandoClienteTestDataBuilder {

    private Long id;
    private String nombre;
    private String direccion;


    public ComandoClienteTestDataBuilder() {
        //Random r = new Random();
        this.id=123456789L;//r.nextLong();
        this.nombre = "JEFER";
        this.direccion = "KR90#23";
    }

    public ComandoClienteTestDataBuilder conNombre(String nombre){
        this.nombre=nombre;
        return this;
    }

    public  ComandoClienteTestDataBuilder conDireccion(String direccion){
        this.direccion=direccion;
        return this;
    }
    public ComandoCliente build(){
        return new ComandoCliente(id,nombre,direccion);
    }

}
