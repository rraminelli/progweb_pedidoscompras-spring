package br.com.ada.bancobrasil.pedidocompras.service.impl.pedido;

import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@Order(30)
public class EnviarEmailCliente implements ValidarPedido {

    public void validar(Pedido pedido) {
        log.info("EnviarEmailCliente");
    }

}
