package io.github.pedoivoz.icompras.faturamento.publisher.representation;

public record AtualizacaoStatusPedido(
        Long codigo, StatusPedido status, String urlNotaFiscal) {
}
