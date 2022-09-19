package br.com.ada.bancobrasil.pedidocompras.service.impl;

import br.com.ada.bancobrasil.pedidocompras.entity.Usuario;
import br.com.ada.bancobrasil.pedidocompras.entity.enums.PerfilEnum;
import br.com.ada.bancobrasil.pedidocompras.repository.UsuarioRepository;
import br.com.ada.bancobrasil.pedidocompras.service.UsuarioService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public Usuario save(Usuario usuario) {
        usuario.setPerfil(PerfilEnum.CLIENTE);
        return usuarioRepository.save(usuario);
    }

    @Override
    @Transactional(readOnly = false)
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Usuario getById(Long userId) {
        return usuarioRepository.findById(userId).get();
    }

}
