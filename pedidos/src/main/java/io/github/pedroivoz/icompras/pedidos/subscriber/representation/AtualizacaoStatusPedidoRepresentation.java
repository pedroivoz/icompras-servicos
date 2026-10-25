package io.github.pedroivoz.icompras.pedidos.subscriber.representation;

import io.github.pedroivoz.icompras.pedidos.model.enums.StatusPedido;

public record AtualizacaoStatusPedidoRepresentation (
        Long codigo,
        StatusPedido status,
        String urlNotaFiscal,
        String codigoRastreio
){


}
