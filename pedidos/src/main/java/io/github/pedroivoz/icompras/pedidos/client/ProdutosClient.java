package io.github.pedroivoz.icompras.pedidos.client;

import io.github.pedroivoz.icompras.pedidos.client.representation.ProdutoRepresentation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name="produtos", url= "${icompras.pedido.clients.produtos.url}")
public interface ProdutosClient {

    @GetMapping("{codigo}")
    ResponseEntity<ProdutoRepresentation> obterDdos(@PathVariable("codigo") Long codigo);

}
