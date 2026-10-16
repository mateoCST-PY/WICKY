package com.wicky.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wicky.model.Usuario;
import com.wicky.repository.UserRepository;

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
    public Usuario crear(@RequestBody Usuario usuario) {
        return repo.save(usuario);
    }
}