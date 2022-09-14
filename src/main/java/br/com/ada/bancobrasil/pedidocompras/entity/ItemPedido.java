package br.com.ada.bancobrasil.pedidocompras.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
public class ItemPedido {

    private Long id;
    private Pedido pedido;
    private Produto produto;
    private Integer quantidade;
    private BigDecimal preco;
    private BigDecimal desconto;

}
