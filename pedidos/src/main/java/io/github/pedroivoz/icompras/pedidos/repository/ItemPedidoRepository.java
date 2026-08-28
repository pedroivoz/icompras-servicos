package io.github.pedroivoz.icompras.pedidos.repository;

import io.github.pedroivoz.icompras.pedidos.model.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemPedidoRepository extends JpaRepository<ItemPedido, Long> {
}
