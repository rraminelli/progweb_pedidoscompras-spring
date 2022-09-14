package br.com.ada.bancobrasil.pedidocompras.entity;

import br.com.ada.bancobrasil.pedidocompras.entity.enums.StatusPedidoEnum;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
public class Pedido {

    private Long id;
    private Usuario usuario;
    private LocalDateTime dataPedido;
    private StatusPedidoEnum status;
    private String mensagemStatus;
    private Set<ItemPedido> itens;

}
