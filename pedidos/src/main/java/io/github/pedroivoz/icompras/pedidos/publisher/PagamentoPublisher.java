package io.github.pedroivoz.icompras.pedidos.publisher;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class PagamentoPublisher {


    private final DetalhePedidoMapper mapper;
    private final ObjectMapper objectMapper;
    private final KafkaTemplate<String, String> kafkaTemplate;

    @Value("${icompras.config.kafka.topics.pedido-pagos}")
    private String topico;



    public void publicar(Pedido pedido) {
    log.info("Publicando pedido {}", pedido);

    try {
        var representation= mapper.map(pedido);
        var json= objectMapper.writeValueAsString(representation);
        kafkaTemplate.send(topico, "dados", json);

    } catch (JsonProcessingException e) {
        log.error("erro ao processar o json", e);
    } catch (RuntimeException e) {
        log.error("erro ao publicar no tópico de pedidos", e);
    }



    }
}
