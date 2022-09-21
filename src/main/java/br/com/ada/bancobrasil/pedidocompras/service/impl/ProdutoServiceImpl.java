package br.com.ada.bancobrasil.pedidocompras.service.impl;

import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import br.com.ada.bancobrasil.pedidocompras.repository.ProdutoRepository;
import br.com.ada.bancobrasil.pedidocompras.service.ProdutoService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    final ProdutoRepository produtoRepository;

    public ProdutoServiceImpl(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    @Override
    @Transactional
    public Produto save(Produto produto) {
        return produtoRepository.save(produto);
    }

    @Override
    @Transactional
    public void save(List<Produto> produtos) {
        produtoRepository.saveAll(produtos);
    }

    @Override
    @Transactional
    public void delete(Long idProduto) {
        produtoRepository.deleteById(idProduto);
    }

    @Override
    @Transactional(readOnly = true)
    public Produto getById(Long id) {
        return produtoRepository.findById(id).get();
    }

    @Override
    @Transactional(readOnly = true)
    public Page<Produto> findAll(String filter, Pageable pageable) {

        /*return produtoRepository.findByNomeContainingOrDescricaoContaining
                (filter, filter, pageable);*/

        Produto produto = new Produto();
        produto.setNome(filter);
        produto.setDescricao(filter);

        final ExampleMatcher exampleMatcher =
                ExampleMatcher
                        .matchingAny()
                        .withIgnoreCase()
                        .withStringMatcher(ExampleMatcher.StringMatcher.CONTAINING);

        Example<Produto> produtoExample = Example.of(produto, exampleMatcher);

        return produtoRepository.findAll(produtoExample, pageable);

        //return produtoRepository.findByFilterNative(filter.toUpperCase(), pageable);

    }

    @Override
    @Transactional(readOnly = true)
    public boolean exists() {
        return produtoRepository.count() > 0;
    }

}
