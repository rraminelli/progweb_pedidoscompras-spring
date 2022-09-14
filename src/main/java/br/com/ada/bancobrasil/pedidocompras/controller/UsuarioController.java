package br.com.ada.bancobrasil.pedidocompras.controller;

import br.com.ada.bancobrasil.pedidocompras.entity.Usuario;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @PostMapping
    public void insert(@RequestBody Usuario usuario) {
        log.info(usuario.toString());
        //insert no banco de dados
    }

    ////http://localhost:8080/usuario?nome=Antonio&id=
    @GetMapping
    public ResponseEntity<List<Usuario>> getAll(String nome, String id) {
        Usuario usuario = new Usuario();
        usuario.setId(123L);
        return ResponseEntity.ok(List.of(usuario));
    }

    //http://localhost:8080/usuario/123
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getById(@PathVariable("id") Long userId) {
        Usuario usuario = new Usuario();
        usuario.setId(userId);
        return ResponseEntity.ok(usuario);
    }


}
