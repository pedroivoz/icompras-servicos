package io.github.pedroivoz.icompras.pedidos.client.representation;

public record ClienteRepresentation(
        Long codigo,
        String nome,
        String cpf,
        String Logradouro,
        String numero,
        String bairro,
        String email,
        String telefone)
{
}
