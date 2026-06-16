package com.mok.mokbackend.service;

import com.mok.mokbackend.model.*;
import com.mok.mokbackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FavoritoService {

    private final FavoritoRepository favoritoRepository;
    private final UsuarioRepository usuarioRepository;
    private final OutfitRepository outfitRepository;

    public FavoritoService(FavoritoRepository f, UsuarioRepository u, OutfitRepository o){
        this.favoritoRepository = f;
        this.usuarioRepository = u;
        this.outfitRepository = o;
    }

    public Favorito agregar(Long usuarioId, Long outfitId){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        Outfit outfit = outfitRepository.findById(outfitId)
                .orElseThrow(() -> new RuntimeException("Outfit no encontrado"));

        Favorito fav = new Favorito();
        fav.setUsuario(usuario);
        fav.setOutfit(outfit);

        return favoritoRepository.save(fav);
    }

    public List<Favorito> listar(Long usuarioId){
        return favoritoRepository.findByUsuarioId(usuarioId);
    }

    public void eliminar(Long id){
        favoritoRepository.deleteById(id);
    }
}