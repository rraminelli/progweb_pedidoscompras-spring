package br.com.ada.bancobrasil.pedidocompras.entity;

import br.com.ada.bancobrasil.pedidocompras.entity.enums.StatusPedidoEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;

@Getter
@Setter
@Entity
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    private LocalDateTime dataPedido;

    @Enumerated(EnumType.STRING)
    private StatusPedidoEnum status;

    private String mensagemStatus;

    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL)
    private Set<ItemPedido> itens;

}
