package br.com.ada.bancobrasil.pedidocompras.service;

import br.com.ada.bancobrasil.pedidocompras.entity.Usuario;

import java.util.List;

public interface UsuarioService {

    Usuario save(Usuario usuario);

    List<Usuario> findAll();

    Usuario getById(Long userId);
}
