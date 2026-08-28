package io.github.pedroivoz.icompras.pedidos.controller;

import io.github.pedroivoz.icompras.pedidos.service.PedidoService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedidos/callback-pagamentos")
@RequiredArgsConstructor
public class RcebimentoCallBackPagamentoController {

    private final PedidoService pedidoService;
    



}
