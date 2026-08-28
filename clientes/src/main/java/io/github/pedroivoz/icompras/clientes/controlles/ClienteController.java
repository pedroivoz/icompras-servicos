package io.github.pedroivoz.icompras.clientes.controlles;

import io.github.pedroivoz.icompras.clientes.model.Cliente;
import io.github.pedroivoz.icompras.clientes.service.ClienteService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;

    @PostMapping
    public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
        Cliente salvar = service.salvar(cliente);
        return ResponseEntity.ok(salvar);
    }

    @GetMapping("{codigo}")
    public ResponseEntity<Cliente> ObterPorCodigo(@PathVariable Long codigo) {
        return service
                .obterPorCodigo(codigo)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
