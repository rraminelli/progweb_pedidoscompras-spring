package br.com.ada.bancobrasil.pedidocompras.service.impl.pedido;

import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.entity.enums.StatusPedidoEnum;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Order(20)
public class RealizarBaixaNoEstoque implements ValidarPedido {

    final ProdutoService produtoService;

    public RealizarBaixaNoEstoque(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    public void validar(Pedido pedido) {
        log.info("RealizarBaixaNoEstoque");

        if (!StatusPedidoEnum.NOVO.equals(pedido.getStatus())) {
            return;
        }

        pedido.getItens().forEach(item -> {
            final Produto produto = produtoService.getById(item.getProduto().getId());
            produto.setEstoque(produto.getEstoque() - item.getQuantidade());
            produtoService.save(produto);
        });

    }

}
