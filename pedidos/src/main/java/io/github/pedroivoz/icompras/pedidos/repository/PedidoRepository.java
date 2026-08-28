package io.github.pedroivoz.icompras.pedidos.repository;

import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface PedidoRepository extends CrudRepository<Pedido, Long> {

    Optional<Pedido> findByCodigoAndChavePagamento(Long codigo, String chavePagamento);
}
