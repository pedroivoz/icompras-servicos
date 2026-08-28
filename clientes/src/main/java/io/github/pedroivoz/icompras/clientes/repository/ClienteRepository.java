package io.github.pedroivoz.icompras.clientes.repository;

import io.github.pedroivoz.icompras.clientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
