package com.wesley.controller;

import com.wesley.model.Usuario;
import com.wesley.repository.UsuarioRepository;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioRepository repository;
    private static final Logger logger = LoggerFactory.getLogger(UsuarioController.class);

    @GetMapping
    public List<Usuario> listar() {
        logger.info("Listando usuários");
        return repository.findAll();
    }

    @PostMapping
    public Usuario criar(@RequestBody Usuario usuario) {
        logger.info("Criando usuário: {}", usuario);
        return repository.save(usuario);
    }

    @GetMapping("/{id}")
    public Usuario buscar(@PathVariable Long id) {
        logger.info("Buscando usuário com id: {}", id);
        return repository.findById(id).orElseThrow();
    }

    @PutMapping("/{id}")
    public Usuario atualizar(@PathVariable Long id, @RequestBody Usuario usuario) {
        logger.info("Atualizando usuário id: {}", id);
        Usuario existente = repository.findById(id).orElseThrow();
        existente.setNome(usuario.getNome());
        existente.setEmail(usuario.getEmail());
        existente.setDocumento(usuario.getDocumento());
        return repository.save(existente);
    }

    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        logger.info("Deletando usuário id: {}", id);
        repository.deleteById(id);
    }
}
