package br.com.ada.bancobrasil.pedidocompras.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(exclude = "usuario")
public class Endereco {

    private Long id;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String uf;
    private String cep;
    private Usuario usuario;

}
