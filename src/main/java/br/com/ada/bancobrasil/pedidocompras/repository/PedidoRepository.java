package br.com.ada.bancobrasil.pedidocompras.repository;

import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
}
