package com.ceiba.pedido.puerto.repositorio;

import com.ceiba.pedido.modelo.entidad.Pedido;


public interface RepositorioPedido {
    /**
     * Permite crear un pedido
     * @param pedido
     * @return el id generado
     */
    Long crear(Pedido pedido);

    /**
     * Permite actualizar un usuario
     * @param pedido
     */
    void actualizar(Pedido pedido);

    /**
     * Permite eliminar un pedido
     * @param id
     */
    void eliminar(Long id);

    /**
     * Permite validar si existe un pedido con un id
     * @param id
     * @return si existe o no
     */
    boolean existe(Long id);

    /**
     * Permite validar si existe un usuario con un nombre excluyendo un id
     * @param nombre
     * @return si existe o no
     */
    boolean existeExcluyendoId(Long id,String nombre);



}

