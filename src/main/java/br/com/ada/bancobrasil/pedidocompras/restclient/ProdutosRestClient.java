package br.com.ada.bancobrasil.pedidocompras.restclient;

import br.com.ada.bancobrasil.pedidocompras.dto.ProdutoImportListDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        configuration = ProductHeaderApi.class,
        value = "produtosRestClient",
        url = "${app.import.products}"
)
public interface ProdutosRestClient {

    @GetMapping(value = "/products/search")
    ProdutoImportListDto find(@RequestParam("q") String filtro);

}
