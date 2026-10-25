package io.github.pedroivoz.icompras.pedidos.service;


import io.github.pedroivoz.icompras.pedidos.client.ClientesClient;
import io.github.pedroivoz.icompras.pedidos.client.ProdutosClient;
import io.github.pedroivoz.icompras.pedidos.client.ServicoBancarioClient;
import io.github.pedroivoz.icompras.pedidos.model.DadosPagamento;
import io.github.pedroivoz.icompras.pedidos.model.ItemPedido;
import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.model.enums.StatusPedido;
import io.github.pedroivoz.icompras.pedidos.model.enums.TipoPagamento;
import io.github.pedroivoz.icompras.pedidos.model.exception.ItemNaoEncontradoExcpetion;
import io.github.pedroivoz.icompras.pedidos.publisher.PagamentoPublisher;
import io.github.pedroivoz.icompras.pedidos.repository.ItemPedidoRepository;
import io.github.pedroivoz.icompras.pedidos.repository.PedidoRepository;
import io.github.pedroivoz.icompras.pedidos.validator.PedidoValidator;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class PedidoService {

    private final PedidoRepository repository;
    private final ItemPedidoRepository itemPedidoRepository;
    private final PedidoValidator validator;
    private final ServicoBancarioClient servicoBancarioClient;
    private final PedidoRepository pedidoRepository;
    private final ClientesClient apiClientes;
    private final ProdutosClient apiProdutos;
    private final PagamentoPublisher pagamentoPublisher;

    @Transactional
    public Pedido criarPedido(Pedido pedido) {
        validator.validar(pedido);
        realizarPersistencia(pedido);
        enviarSolicitaçaoPagmento(pedido);
        return pedido;
    }

    private void enviarSolicitaçaoPagmento(Pedido pedido) {
        var chavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(chavePagamento);
    }

    private void realizarPersistencia(Pedido pedido) {
        repository.save(pedido);
        itemPedidoRepository.saveAll(pedido.getItens());
    }


    public void atualizarStatusPagamento(
            Long codigoPedido, String chavePagamento, boolean sucesso, String observacoes) {
        var pedidoEncontrado = pedidoRepository
                .findByCodigoAndChavePagamento(codigoPedido, chavePagamento);

        if(pedidoEncontrado.isEmpty()){
            var msg = String.format("Pedido não encontrado para o codigo %d e chave de pagamento %d",
                    codigoPedido, chavePagamento);
            log.error(msg);
            return;
        }

        Pedido pedido = pedidoEncontrado.get();

        if (sucesso){
            prepararEPublicarPedidoPago(observacoes, pedido);


        } else {
            pedido.setStatus(StatusPedido.ERRO_PAGAMENTO);
            pedido.setObservacoes(observacoes);
        }
        repository.save(pedido);
    }

    private void prepararEPublicarPedidoPago(String observacoes, Pedido pedido) {
        pedido.setStatus(StatusPedido.PAGO);
        carregarDadosCliente(pedido);
        carregarItensPedido(pedido);
        pagamentoPublisher.publicar(pedido);
    }

    public void adicionarNovoPagamento(
            Long codigoPedido, String dadosCartao, TipoPagamento tipo){
        var pedidoEncontrado = pedidoRepository.findById(codigoPedido);

        if(pedidoEncontrado.isEmpty()){
            throw new ItemNaoEncontradoExcpetion("Pedido não encontrado para o código informado");
        }
        var pedido = pedidoEncontrado.get();

        DadosPagamento dadosPagamento = new DadosPagamento();
        dadosPagamento.setTipoPagamento(tipo);
        dadosPagamento.setDados(dadosCartao);

        pedido.setDadosPagamento(dadosPagamento);
        pedido.setStatus(StatusPedido.REALIZADO);
        pedido.setObservacoes("Novo pagamento realizado, aguardando o processamento.");

        String novaChavePagamento = servicoBancarioClient.solicitarPagamento(pedido);
        pedido.setChavePagamento(novaChavePagamento);

        repository.save(pedido);
    }

    public Optional<Pedido> carregarDadosCompletosPedido(Long codigo) {
        Optional<Pedido> pedido = repository.findById(codigo);
        pedido.ifPresent(this::carregarDadosCliente);
        pedido.ifPresent(this::carregarItensPedido);
        return pedido;
    }

    private void carregarDadosCliente(Pedido pedido) {
        Long codigoCliente = pedido.getCodigoCliente();
        var response = apiClientes.obterDados(codigoCliente);
        pedido.setDadosCliente(response.getBody());
    }

    private void carregarItensPedido(Pedido pedido) {
        List<ItemPedido> itens= itemPedidoRepository.findByPedido(pedido);
        pedido.setItens(itens);
        pedido.getItens().forEach(this::carregarDadosProdutos);

    }

    private void carregarDadosProdutos(ItemPedido item) {
        Long codigoProduto  = item.getCodigoProduto();
        var response= apiProdutos.obterDdos(codigoProduto);
        item.setNome(response.getBody().nome());
    }
}
