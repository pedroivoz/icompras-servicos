package io.github.pedroivoz.icompras.pedidos.controller.dto;

import io.github.pedroivoz.icompras.pedidos.model.enums.TipoPagamento;

public record AdicaoNovoPagamentoDTO(
        Long codigoPedido, String dados, TipoPagamento tipoPagamento) {
}
