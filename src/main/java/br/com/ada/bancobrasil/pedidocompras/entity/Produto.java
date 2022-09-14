package br.com.ada.bancobrasil.pedidocompras.entity;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class Produto {

    private Long id;
    private String nome;
    private String descricao;
    private BigDecimal preco;
    private BigDecimal desconto;
    private Integer estoque;
    private String foto;

}
