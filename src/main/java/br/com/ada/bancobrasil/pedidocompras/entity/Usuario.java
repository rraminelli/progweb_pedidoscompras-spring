package br.com.ada.bancobrasil.pedidocompras.entity;

import br.com.ada.bancobrasil.pedidocompras.entity.enums.PerfilEnum;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@EqualsAndHashCode(exclude = "endereco")
@ToString
public class Usuario {

    private Long id;
    private String nome;
    private String cpf;
    private String email;
    private String senha;
    private Endereco endereco;
    private PerfilEnum perfil;

}
