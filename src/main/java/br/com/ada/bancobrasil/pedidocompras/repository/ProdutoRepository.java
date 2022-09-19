package br.com.ada.bancobrasil.pedidocompras.repository;

import br.com.ada.bancobrasil.pedidocompras.entity.Produto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long> {

    Page<Produto> findByNomeContainingOrDescricaoContaining
            (String nome, String descricao, Pageable pageable);

    @Query("select p from Produto p where upper(p.nome) like %:filter% or upper(p.descricao) like %:filter% ")
    Page<Produto> findByFilter(@Param("filter") String filter, Pageable pageable);

    @Query(
            value = "select * from produto p where upper(p.nome) like %:filter% or upper(p.descricao) like %:filter% ",
            nativeQuery = true
    )
    Page<Produto> findByFilterNative(@Param("filter") String filter, Pageable pageable);

}
