package br.com.ada.bancobrasil.pedidocompras.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PedidoItemDto {

    private Long produtoId;
    private Integer quantidade;

}
