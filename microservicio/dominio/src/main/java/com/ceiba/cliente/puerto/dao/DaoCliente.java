package com.ceiba.cliente.puerto.dao;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.usuario.modelo.dto.DtoUsuario;

import java.util.List;

public interface DaoCliente {

    /**
     * Permite listar clientes
     * @return los usuarios
     */
    List<DtoCliente> listar();
}
