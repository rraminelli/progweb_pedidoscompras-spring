package br.com.ada.bancobrasil.pedidocompras.service.impl.pedido;

import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.entity.enums.StatusPedidoEnum;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@Order(10)
public class ValidarEstoquePedido implements ValidarPedido {

    final ProdutoService produtoService;

    public ValidarEstoquePedido(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void validar(Pedido pedido) {
        log.info("ValidarEstoquePedido");

        pedido.getItens().forEach(item -> {
            final Produto produto = produtoService.getById(item.getProduto().getId());
            if (produto.getEstoque() < item.getQuantidade()) {
                pedido.setStatus(StatusPedidoEnum.CANCELADO);
                pedido.setMensagemStatus("Quantidade do produto " + produto.getNome() + " nao disponivel em estoque");
            }
        });


    }

}
