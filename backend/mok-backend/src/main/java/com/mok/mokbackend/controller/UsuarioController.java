package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Usuario;
import com.mok.mokbackend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    private final UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }

    @GetMapping
    public List<Usuario> obtenerTodos() {
        return service.obtenerTodos();
    }

    @PostMapping
    public Usuario crear(@RequestBody Usuario usuario) {
        return service.crear(usuario);
    }

    @PostMapping("/login")
    public String login(@RequestBody Usuario usuario) {

        Usuario encontrado = service.buscarPorEmail(usuario.getEmail());

        if (encontrado == null) {
            return "Usuario no encontrado";
        }

        if (!encontrado.getPassword().equals(usuario.getPassword())) {
            return "Password incorrecta";
        }

        return "Login exitoso";
    }
}