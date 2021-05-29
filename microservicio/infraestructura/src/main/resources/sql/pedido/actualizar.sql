update pedido
set fecha = :fecha,
	clienteId = :clienteId,
	iva =:iva,
	valorEnvio = :valorEnvio,
	total = :total
where id = :id
