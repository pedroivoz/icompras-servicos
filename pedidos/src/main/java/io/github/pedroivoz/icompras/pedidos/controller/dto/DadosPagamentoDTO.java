package io.github.pedroivoz.icompras.pedidos.controller.dto;

import io.github.pedroivoz.icompras.pedidos.model.enums.TipoPagamento;

public record DadosPagamentoDTO(
        String dados,
        TipoPagamento tipoPagamento) {
}
