package com.ceiba.configuracion;

import com.ceiba.cliente.puerto.repositorio.RepositorioCliente;
import com.ceiba.cliente.servicio.ServicioActualizarCliente;
import com.ceiba.cliente.servicio.ServicioCrearCliente;
import com.ceiba.cliente.servicio.ServicioEliminarCliente;
import com.ceiba.pedido.puerto.dao.DaoPedido;
import com.ceiba.pedido.puerto.repositorio.RepositorioPedido;
import com.ceiba.pedido.servicio.ServicioActualizarPedido;
import com.ceiba.pedido.servicio.ServicioCrearPedido;
import com.ceiba.pedido.servicio.ServicioEliminarPedido;
import com.ceiba.pedidoProducto.puerto.repositorio.RepositorioPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioCrearPedidoProducto;
import com.ceiba.pedidoProducto.servicio.ServicioEliminarPedidoProducto;
import com.ceiba.producto.puerto.repositorio.RepositorioProducto;
import com.ceiba.producto.servicio.ServicioActualizarProducto;
import com.ceiba.producto.servicio.ServicioCrearProducto;
import com.ceiba.producto.servicio.ServicioEliminarProducto;
import com.ceiba.usuario.puerto.repositorio.RepositorioUsuario;
import com.ceiba.usuario.servicio.ServicioActualizarUsuario;
import com.ceiba.usuario.servicio.ServicioCrearUsuario;
import com.ceiba.usuario.servicio.ServicioEliminarUsuario;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioCrearUsuario servicioCrearUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioCrearUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioEliminarUsuario servicioEliminarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioEliminarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioActualizarUsuario servicioActualizarUsuario(RepositorioUsuario repositorioUsuario) {
        return new ServicioActualizarUsuario(repositorioUsuario);
    }

    @Bean
    public ServicioCrearCliente servicioCrearCliente(RepositorioCliente repositorioCliente){
        return  new ServicioCrearCliente(repositorioCliente);
    }

    @Bean
    public ServicioEliminarCliente servicioEliminarCliente(RepositorioCliente repositorioCliente){
        return  new ServicioEliminarCliente(repositorioCliente);
    }
    @Bean
    public ServicioActualizarCliente servicioActualizarCliente(RepositorioCliente repositorioCliente){
        return new ServicioActualizarCliente(repositorioCliente);
    }
    @Bean
    public ServicioCrearProducto servicioCrearProducto(RepositorioProducto repositorioProducto){
        return new ServicioCrearProducto(repositorioProducto);
    }

    @Bean
    public ServicioActualizarProducto servicioActualizarProducto(RepositorioProducto repositorioProducto){
        return new ServicioActualizarProducto(repositorioProducto);
    }
    @Bean
    public ServicioEliminarProducto servicioEliminarProducto(RepositorioProducto repositorioProducto){
        return new ServicioEliminarProducto(repositorioProducto);
    }
    @Bean
    public ServicioCrearPedido servicioCrearPedido(RepositorioPedido repositorioPedido){
        return new ServicioCrearPedido(repositorioPedido);
    }
    @Bean
    public ServicioActualizarPedido servicioActualizarPedido(RepositorioPedido repositorioPedido, DaoPedido daoPedido){
        return new ServicioActualizarPedido(repositorioPedido,daoPedido);
    }
    @Bean
    public ServicioEliminarPedido servicioEliminarPedido(RepositorioPedido repositorioPedido){
        return new ServicioEliminarPedido( repositorioPedido);
    }
    @Bean
    public ServicioCrearPedidoProducto servicioCrearPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto){
        return  new ServicioCrearPedidoProducto(repositorioPedidoProducto);
    }
    @Bean
    public ServicioEliminarPedidoProducto servicioEliminarPedidoProducto(RepositorioPedidoProducto repositorioPedidoProducto){
        return new ServicioEliminarPedidoProducto(repositorioPedidoProducto);
    }
}
