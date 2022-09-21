package br.com.ada.bancobrasil.pedidocompras.service;

import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProdutoService {

    Produto save(Produto produto);

    void delete(Long idProduto);

    Page<Produto> findAll(String filtro, Pageable pageable);

    Produto getById(Long id);

    void save(List<Produto> produtos);

    boolean exists();
}
