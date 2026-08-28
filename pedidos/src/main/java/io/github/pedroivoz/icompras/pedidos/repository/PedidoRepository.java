package io.github.pedroivoz.icompras.pedidos.repository;

import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import org.springframework.data.repository.CrudRepository;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {
}
