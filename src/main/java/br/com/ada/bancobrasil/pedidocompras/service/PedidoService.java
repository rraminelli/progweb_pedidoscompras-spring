package br.com.ada.bancobrasil.pedidocompras.service;

import br.com.ada.bancobrasil.pedidocompras.dto.RealizarPedidoDto;
import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;

public interface PedidoService {

    Pedido realizarPedido(RealizarPedidoDto realizarPedidoDto);

}
