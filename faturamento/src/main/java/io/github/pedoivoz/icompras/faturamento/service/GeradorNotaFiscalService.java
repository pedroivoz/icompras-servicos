package io.github.pedoivoz.icompras.faturamento;

import io.github.pedoivoz.icompras.faturamento.bucket.BucketFile;
import io.github.pedoivoz.icompras.faturamento.bucket.BucketService;
import io.github.pedoivoz.icompras.faturamento.model.Pedido;
import io.github.pedoivoz.icompras.faturamento.service.NotaFiscalService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;

@Slf4j
@Component
@RequiredArgsConstructor
public class GeradorNotaFiscalService {

    private final NotaFiscalService notaFiscalService;
    private final BucketService bucketService;

    public void gerar(Pedido pedido) {
        log.info("Gerando anota fiscal para o pedido {}", pedido.codigo());

        try {
            byte[] byteArray = notaFiscalService.gerarNotaFiscal(pedido);

            String nomeArquivo = String.format("notafiscal_pedido_%d.pdf", pedido.codigo());
            Long tamanho = Long.parseLong(String.valueOf(byteArray.length));

            var file = new BucketFile(
                    nomeArquivo, new ByteArrayInputStream(byteArray), MediaType.APPLICATION_PDF, tamanho);

            bucketService.upload(file);
            log.info("Gerada a nota fiscal, nome do arquivo {}", nomeArquivo);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }


}
