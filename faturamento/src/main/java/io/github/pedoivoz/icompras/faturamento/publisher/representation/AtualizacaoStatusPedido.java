package io.github.pedoivoz.icompras.faturamento.publisher.representation;

public record AtualizacaoStatusPagamento(
        Long codigo, StatusPedido status, String urlNotaFiscal) {
}
