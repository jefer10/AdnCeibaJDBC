SELECT pedido_producto.id AS pid, producto.*
FROM producto
INNER JOIN pedido_producto
ON producto.id =pedido_producto.productoid
WHERE pedido_producto.pedidoid= :pedidoid