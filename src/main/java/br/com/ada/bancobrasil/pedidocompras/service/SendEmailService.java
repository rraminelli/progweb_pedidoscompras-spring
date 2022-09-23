package br.com.ada.bancobrasil.pedidocompras.service;

import br.com.ada.bancobrasil.pedidocompras.dto.SendEmailDto;

public interface SendEmailService {

    void send(SendEmailDto sendEmailDto);

}
