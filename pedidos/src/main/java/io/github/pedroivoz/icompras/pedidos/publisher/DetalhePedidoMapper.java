package io.github.pedroivoz.icompras.pedidos.publisher;

import io.github.pedroivoz.icompras.pedidos.model.Pedido;
import io.github.pedroivoz.icompras.pedidos.publisher.representation.DetalhePedidoRepresentation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface DetalhePedidoMappe {

    @Mapping(source= "codigo", target ="codigo")
    @Mapping(source= "codigoCliente", target ="codigoCliente")
    @Mapping(source= "nome", target ="nome")
    @Mapping(source= "", target ="")
    @Mapping(source= "", target ="")
    @Mapping(source= "", target ="")
    DetalhePedidoRepresentation map(Pedido pedido);
}
