package io.github.pedroivoz.icompras.pedidos.controller;

import io.github.pedroivoz.icompras.pedidos.controller.dto.RecebimentoCallBackPagamentoDTO;
import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.service.PedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RecebimentoCallBackPagamentoController {

    private final PedidoService pedidoService;

    @PostMapping
    public ResponseEntity<Object> atualizarStatusPagamento(
            @RequestBody RecebimentoCallBackPagamentoDTO body,
            @RequestHeader(required = true, name= "apiKey") String apiKey
            ){

        pedidoService.atualizarStatusPagamento(
                body.codigo(),
                body.chavePagamento(),
                body.status(),
                body.observacoes());

    return ResponseEntity.ok().build();
    }


}
