package io.github.pedroivoz.icompras.pedidos.validator;

import io.github.pedroivoz.icompras.pedidos.client.ClientesClient;
import io.github.pedroivoz.icompras.pedidos.client.ProdutosClient;
import io.github.pedroivoz.icompras.pedidos.client.representation.ProdutoRepresentation;
import io.github.pedroivoz.icompras.pedidos.model.ItemPedido;
import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class PedidoValidator {

    private final ProdutosClient produtosClient;
    private final ClientesClient clientesClient;

    public void validar(Pedido pedido){
        Long codigoCLiente = pedido.getCodigoCliente();
        validarCliente(codigoCLiente);
        pedido.getItens().forEach(this::validarItem);
    }

    private void validarCliente(Long codigoCliente){

    }
    private void validarItem(ItemPedido item){

    }
}
