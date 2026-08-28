package io.github.pedroivoz.icompras.clientes.service;

import io.github.pedroivoz.icompras.clientes.model.Cliente;
import io.github.pedroivoz.icompras.clientes.repository.ClienteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository repository;

    public Cliente salvar(Cliente cliente) {
        Cliente clienteSalva = repository.save(cliente);
        return clienteSalva;

    }

    public Optional<Cliente> obterPorCodigo(Long id) {
        return repository.findById(id);
    }


}
