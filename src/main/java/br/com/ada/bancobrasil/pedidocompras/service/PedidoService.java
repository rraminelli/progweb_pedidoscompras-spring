package br.com.ada.bancobrasil.pedidocompras.service;

import br.com.ada.bancobrasil.pedidocompras.dto.RealizarPedidoDto;
import br.com.ada.bancobrasil.pedidocompras.dto.RealizarPedidoResponseDto;
import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;

public interface PedidoService {

    RealizarPedidoResponseDto realizarPedido(RealizarPedidoDto realizarPedidoDto);

}
