package com.ceiba.cliente.consulta;

import com.ceiba.cliente.modelo.dto.DtoCliente;
import com.ceiba.cliente.puerto.dao.DaoCliente;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ManejadorBuscarCliente {

    private final DaoCliente daoCliente;

    public ManejadorBuscarCliente(DaoCliente daoCliente) {
        this.daoCliente = daoCliente;
    }

    public DtoCliente ejecutar(long id){
        return  this.daoCliente.findById(id);
    }
}
