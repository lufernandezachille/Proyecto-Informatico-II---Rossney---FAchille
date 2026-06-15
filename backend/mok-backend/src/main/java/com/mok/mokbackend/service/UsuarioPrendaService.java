package com.mok.mokbackend.service;

import com.mok.mokbackend.model.*;
import com.mok.mokbackend.repository.UsuarioPrendaRepository;
import com.mok.mokbackend.repository.UsuarioRepository;
import com.mok.mokbackend.repository.PrendaRepository;

import org.springframework.stereotype.Service;

import java.util.stream.Collectors;
import java.util.List;

@Service
public class UsuarioPrendaService {

    private final UsuarioPrendaRepository usuarioPrendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final PrendaRepository prendaRepository;

    public UsuarioPrendaService(
            UsuarioPrendaRepository usuarioPrendaRepository,
            UsuarioRepository usuarioRepository,
            PrendaRepository prendaRepository
    ){
        this.usuarioPrendaRepository = usuarioPrendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.prendaRepository = prendaRepository;
    }

    // Agregar prenda del catálogo al armario
    public UsuarioPrenda agregarPrenda(Long usuarioId, Long prendaId){

        if(usuarioPrendaRepository.existsByUsuarioIdAndPrendaId(usuarioId, prendaId)){
            throw new RuntimeException("Ya tenés esta prenda en tu armario");
        }

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Prenda prenda = prendaRepository.findById(prendaId)
                .orElseThrow(() -> new RuntimeException("Prenda no encontrada"));

        UsuarioPrenda nueva = new UsuarioPrenda();
        nueva.setUsuario(usuario);
        nueva.setPrenda(prenda);
        nueva.setPropia(false);

        return usuarioPrendaRepository.save(nueva);
    }

    // Ver armario del usuario
    public List<UsuarioPrenda> obtenerArmario(Long usuarioId){
        return usuarioPrendaRepository
                .findByUsuarioId(usuarioId);
    }

    public List<Prenda> obtenerPrendasDelUsuario(Long usuarioId){
        return usuarioPrendaRepository.findByUsuarioId(usuarioId)
                .stream()
                .map(UsuarioPrenda::getPrenda)
                .collect(Collectors.toList());
    }
}