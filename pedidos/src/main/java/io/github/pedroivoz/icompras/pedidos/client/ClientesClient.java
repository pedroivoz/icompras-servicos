package io.github.pedroivoz.icompras.pedidos.client;

import io.github.pedroivoz.icompras.pedidos.client.representation.ClienteRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "clientes", url = "${icompras.pedido.clients.clientes.url}")
public interface ClientesClient {

    @GetMapping("{codigo}")
    ResponseEntity<ClienteRepresentation> obterDados(@PathVariable("codigo") Long codigo);
}
