package io.github.pedroivoz.icompras.pedidos.validator;

import feign.FeignException;
import io.github.pedroivoz.icompras.pedidos.client.ClientesClient;
import io.github.pedroivoz.icompras.pedidos.client.ProdutosClient;
import io.github.pedroivoz.icompras.pedidos.client.representation.ClienteRepresentation;
import io.github.pedroivoz.icompras.pedidos.client.representation.ProdutoRepresentation;
import io.github.pedroivoz.icompras.pedidos.model.ItemPedido;
import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.model.exception.ValidationException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido){
        Long codigoCLiente = pedido.getCodigoCliente();
        validarCliente(codigoCLiente);
        pedido.getItens().forEach(this::validarItem);
    }

    private void validarCliente(Long codigoCliente) {
        try {
            var response = clientesClient.obterDados(codigoCliente);
            ClienteRepresentation cliente = response.getBody();
            log.info("Cliente de codigo {} encontrado: {}", cliente.codigo(), cliente.nome());
        } catch (FeignException.NotFound e) {
                var message =  String.format("Cliente de codigo %d não encontrado", codigoCliente);
                throw new ValidationException("codigoCliente", message);

        }
    }
    private void validarItem(ItemPedido item){
            try {
                var response = produtosClient.obterDdos(item.getCodigoProduto());
                ProdutoRepresentation produto = response.getBody();
                log.info("Produto de codigo {} encontrado: {}", produto.codigo(), produto.nome());
            } catch (FeignException.NotFound e) {
                var message =  String.format("Produto de codigo %d não encontrado",item.getCodigoProduto() );
                throw new ValidationException("codigoCliente", message);

            }

    }

}
