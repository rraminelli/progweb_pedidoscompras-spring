package br.com.ada.bancobrasil.pedidocompras.entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "produto")
public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome")
    @NotNull(message = "Nome é obrigatorio")
    private String nome;

    private String descricao;

    @NotNull(message = "Preço é obrigatorio")
    private BigDecimal preco;

    private BigDecimal desconto;

    private Integer estoque;

    private String foto;

}
