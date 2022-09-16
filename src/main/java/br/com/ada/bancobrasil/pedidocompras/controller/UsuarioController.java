package br.com.ada.bancobrasil.pedidocompras.controller;

import br.com.ada.bancobrasil.pedidocompras.entity.Usuario;
import br.com.ada.bancobrasil.pedidocompras.service.UsuarioService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }


    @PostMapping
    public ResponseEntity<Usuario> insert(@RequestBody @Valid Usuario usuario) {
        log.info(usuario.toString());
        return ResponseEntity.ok(usuarioService.save(usuario));
    }

    ////http://localhost:8080/usuarios
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll() {
        return ResponseEntity.ok(usuarioService.findAll());
    }

    //http://localhost:8080/usuarios/123
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable(value = "id") Long userId) {
        return ResponseEntity.ok(usuarioService.getById(userId));
    }


}
