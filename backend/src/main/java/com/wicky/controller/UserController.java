package com.wicky.controller;

import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wicky.model.Usuario;
import com.wicky.repository.UserRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/usuarios")

// responsible for receiving the HTTP requests that are sent to the /usuarios
// endpoint and delegating the processing of those requests to the appropriate
// methods in the UserRepository class.

public class UserController {

    private final UserRepository repo;

    public UserController(UserRepository repo) {
        this.repo = repo;
    }

    @GetMapping
    public List<Usuario> listar() {
        return repo.findAll();
    }

    @PostMapping
    public ResponseEntity<?> crear(@Valid @RequestBody Usuario usuario) {
        if (repo.existsByDocumento(usuario.getDocumento())) {
            return ResponseEntity.status(HttpStatus.CONFLICT)
                    .body(Map.of("documento", "Ya existe un usuario con ese documento"));
        }
        return ResponseEntity.ok(repo.save(usuario));
    }
}