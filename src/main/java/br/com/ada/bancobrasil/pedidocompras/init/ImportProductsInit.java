package br.com.ada.bancobrasil.pedidocompras.init;

import br.com.ada.bancobrasil.pedidocompras.dto.ProdutoImportListDto;
import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.restclient.ProdutosRestClient;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Component
public class ImportProductsInit implements InitializingBean {

    final ProdutosRestClient produtosRestClient;
    final ProdutoService produtoService;

    public ImportProductsInit(ProdutosRestClient produtosRestClient, ProdutoService produtoService) {
        this.produtosRestClient = produtosRestClient;
        this.produtoService = produtoService;
    }

    @Override
    public void afterPropertiesSet() throws Exception {

        log.info("afterPropertiesSet - START");

        if (produtoService.exists()) {
            return;
        }

        final ProdutoImportListDto produtoImportListDto = produtosRestClient.find("");

        final List<Produto> produtos = produtoImportListDto.getProducts().stream().map(
                produtoImportDto -> {
                    return new Produto(
                            produtoImportDto.getId(),
                            produtoImportDto.getTitle(),
                            produtoImportDto.getDescription(),
                            produtoImportDto.getPrice(),
                            produtoImportDto.getDiscountPercentage(),
                            produtoImportDto.getStock(),
                            produtoImportDto.getThumbnail()
                    );
                }
        ).collect(Collectors.toList());

        produtoService.save(produtos);

        log.info("afterPropertiesSet - END");


    }

}
