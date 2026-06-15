package com.mok.mokbackend.service;


import com.mok.mokbackend.model.Usuario;
import com.mok.mokbackend.repository.UsuarioRepository;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    
    private final UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario registrarUsuario(Usuario usuario){

        if(usuarioRepository.findByEmail(usuario.getEmail()).isPresent()){
            throw new RuntimeException("El email ya existe");
        }

        return usuarioRepository.save(usuario);
    }

    public Usuario login(String email, String password){

        Usuario usuario = usuarioRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("Usuario no encontrado")
                );

        if(!usuario.getPassword().equals(password)){
            throw new RuntimeException("Contraseña incorrecta");
        }

        return usuario;
    }
}