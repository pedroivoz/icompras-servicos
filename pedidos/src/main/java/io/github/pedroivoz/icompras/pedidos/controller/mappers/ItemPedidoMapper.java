package io.github.pedroivoz.icompras.pedidos.controller.mappers;

import io.github.pedroivoz.icompras.pedidos.controller.dto.ItemPedidoDTO;
import io.github.pedroivoz.icompras.pedidos.model.ItemPedido;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ItemPedidoMapper {

    ItemPedido map(ItemPedidoDTO dto);
}
