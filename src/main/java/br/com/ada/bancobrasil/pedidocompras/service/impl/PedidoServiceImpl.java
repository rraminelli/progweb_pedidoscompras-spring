package br.com.ada.bancobrasil.pedidocompras.service.impl;

import br.com.ada.bancobrasil.pedidocompras.dto.RealizarPedidoDto;
import br.com.ada.bancobrasil.pedidocompras.entity.ItemPedido;
import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.entity.enums.StatusPedidoEnum;
import br.com.ada.bancobrasil.pedidocompras.service.PedidoService;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import br.com.ada.bancobrasil.pedidocompras.service.impl.pedido.ValidarPedido;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class PedidoServiceImpl implements PedidoService {

    final ProdutoService produtoService;
    final List<ValidarPedido> validacoes;

    public PedidoServiceImpl(ProdutoService produtoService, List<ValidarPedido> validacoes) {
        this.produtoService = produtoService;
        this.validacoes = validacoes;
    }

    @Override
    public Pedido realizarPedido(final RealizarPedidoDto realizarPedidoDto) {

        final Pedido pedido = this.criarPedido(realizarPedidoDto);

        validacoes.forEach(validarPedido -> validarPedido.validar(pedido));

        return pedido;
    }

    private Pedido criarPedido(RealizarPedidoDto realizarPedidoDto) {

        /*Set<ItemPedido> itemPedidos = realizarPedidoDto.getItens().stream()
                .map(pedidoItemDto -> {

                    final Produto produto = produtoService.getById(pedidoItemDto.getProdutoId());

                    return ItemPedido.builder()
                            .quantidade(pedidoItemDto.getQuantidade())
                            .produto(produto)
                            .preco(produto.getPreco())
                            .desconto(produto.getDesconto())
                            .build();
                })
                .collect(Collectors.toSet());

        Pedido pedido = Pedido.builder()
                .dataPedido(LocalDateTime.now())
                .status(StatusPedidoEnum.NOVO)
                //.usuario() TODO: SpringSecurity
                .itens(itemPedidos)
                .build();

        return pedido;*/
        return null;

    }

}
