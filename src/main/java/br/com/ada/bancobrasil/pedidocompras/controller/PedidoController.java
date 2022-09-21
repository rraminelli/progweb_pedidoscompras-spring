package br.com.ada.bancobrasil.pedidocompras.controller;

import br.com.ada.bancobrasil.pedidocompras.dto.RealizarPedidoDto;
import br.com.ada.bancobrasil.pedidocompras.entity.Pedido;
import br.com.ada.bancobrasil.pedidocompras.service.PedidoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pedido")
public class PedidoController {

    final PedidoService pedidoService;

    public PedidoController(PedidoService pedidoService) {
        this.pedidoService = pedidoService;
    }

    @PostMapping
    public ResponseEntity<Pedido> realizarPedido(@RequestBody RealizarPedidoDto realizarPedidoDto) {

        return ResponseEntity.ok(pedidoService.realizarPedido(realizarPedidoDto));

    }

}
