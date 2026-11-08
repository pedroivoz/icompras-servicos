package io.github.pedroivoz.icompras.pedidos.service;

import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.model.enums.StatusPedido;
import io.github.pedroivoz.icompras.pedidos.repository.PedidoRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AtualizacaoStatusPedidoService {

    private final PedidoRepository repository;

    @Transactional
    public void atualizarStatus(
            Long codigo, StatusPedido status, String urlNotaFiscal, String rastreio){

            repository.findById(codigo).ifPresent(pedido -> {
                pedido.setStatus(status);
                pedido.setUrlNotaFiscal(urlNotaFiscal);
                pedido.setRastreio(rastreio);
            });
    }
}
