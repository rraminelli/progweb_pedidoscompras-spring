package br.com.ada.bancobrasil.pedidocompras.controller;

import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springdoc.api.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.websocket.server.PathParam;

@RestController
@RequestMapping("/produtos")
public class ProdutoController {

    final ProdutoService produtoService;

    public ProdutoController(ProdutoService produtoService) {
        this.produtoService = produtoService;
    }

    @GetMapping
    @ApiResponse(description = "Lista de produtos, filtro por nome e descricao")
    public ResponseEntity<Page<Produto>> findAll(@RequestParam(value = "filter", required = false) String filter,
                                                 @ParameterObject @PageableDefault(size = 20, page = 0) Pageable pageable) {
        return ResponseEntity.ok(produtoService.findAll(filter, pageable));
    }

    @PreAuthorize("hasAnyRole('ADMIN')")
    @PostMapping
    public ResponseEntity<Produto> save(@Valid @RequestBody Produto produto) {
        return ResponseEntity.ok(produtoService.save(produto));
    }

    //http://server:8080/produtos/1
    @GetMapping("/{id}")
    public ResponseEntity<Produto> getById(@PathVariable("id") Long produtoId) {
        return ResponseEntity.ok(produtoService.getById(produtoId));
    }

    //http://server:8080/produtos/1
    @PreAuthorize("hasAnyRole('ADMIN')")
    @DeleteMapping("/{id}")
    public void delete(@PathVariable("id") Long produtoId) {
        produtoService.delete(produtoId);
    }

}
