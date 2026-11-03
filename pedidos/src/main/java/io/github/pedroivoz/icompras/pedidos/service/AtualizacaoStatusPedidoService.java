package io.github.pedroivoz.icompras.pedidos.service;

import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.model.enums.StatusPedido;
import io.github.pedroivoz.icompras.pedidos.repository.PedidoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository pedidoRepository;

    public void atualizarStatus(
            Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio){

    }
}
