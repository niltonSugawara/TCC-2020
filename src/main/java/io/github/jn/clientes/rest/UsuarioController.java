package io.github.jn.clientes.rest;

import io.github.jn.clientes.model.entity.Usuario;
import io.github.jn.clientes.model.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/usuario")
@CrossOrigin("http://localhost:4200")
public class UsuarioController {

    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @PostMapping
    @ResponseStatus( HttpStatus.CREATED)
    public Usuario salvar (@RequestBody @Valid Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @GetMapping("{id}")
    public Usuario acharUserPorId(@PathVariable Integer id) {
        return usuarioRepository
                .findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"));
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void atualizarUser (@PathVariable Integer id, @RequestBody @Valid Usuario usuarioAtualizado) {
        usuarioRepository
                .findById(id)
                .map(usuario -> {
                    usuario.setNome(usuarioAtualizado.getNome());
                    usuario.setCpf(usuarioAtualizado.getCpf());

                    return usuarioRepository.save(usuarioAtualizado);
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"));
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarUser (@PathVariable Integer id) {
        usuarioRepository
                .findById(id)
                .map(usuario -> {
                    usuarioRepository.delete(usuario);
                    return Void.TYPE;
                })
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                                "Usuário não encontrado"));
    }
}
