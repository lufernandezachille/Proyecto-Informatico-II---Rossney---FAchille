package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Usuario;
import com.mok.mokbackend.service.UsuarioService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/usuarios")
@CrossOrigin(origins = "*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping("/registro")
    public Usuario registrar(@RequestBody Usuario usuario){

        return usuarioService.registrarUsuario(usuario);
    }

    @PostMapping("/login")
    public Usuario login(@RequestBody Usuario usuario){

        return usuarioService.login(
                usuario.getEmail(),
                usuario.getPassword()
        );
    }
}