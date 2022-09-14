package br.com.ada.bancobrasil.pedidocompras.controller;

import br.com.ada.bancobrasil.pedidocompras.dto.ClienteDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
public class TesteController {

    @GetMapping("/cliente")
    public ResponseEntity<ClienteDto> teste() {

        log.info("teste de log - get cliente");
        log.warn("teste de log - get cliente WARN");

        ClienteDto clienteDto = new ClienteDto();
        clienteDto.setNome("Rodrigo");
        clienteDto.setEndereco("Rua A, 10");
        clienteDto.setId("1234");

        return ResponseEntity.ok(clienteDto);

    }

}
