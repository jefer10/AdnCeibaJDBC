create table usuario (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clave varchar(45) not null,
 fecha_creacion datetime null,
 primary key (id)
);

create table cliente (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 direccion varchar(255) not null,
 primary key (id)
);


create table producto (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 descripcion varchar(255) not null,
 valor double not null,
 primary key (id)
);


create table pedido (
 id int(11) not null auto_increment,
 nombre varchar(100) not null,
 clienteid int(11) not null,
 fecha datetime null,
 iva double not null,
 total double not null,
 primary key (id),
);

alter table pedido
  add constraint FK_pedido_cliente
  foreign key (clienteid)
  references cliente(id);

create table pedido_producto(
 id int(11) not null auto_increment,
 pedidoid int(11) not null,
 productoid int(11) not null,
 primary key (id),
);

alter table pedido_producto
  add constraint FK_pedido_producto
  foreign key (pedidoid)
  references pedido(id);


alter table pedido_producto
  add constraint FK_producto_pedido
  foreign key (productoid)
  references producto(id);