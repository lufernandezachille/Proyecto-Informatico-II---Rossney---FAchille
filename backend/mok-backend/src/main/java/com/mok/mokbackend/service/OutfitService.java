package com.mok.mokbackend.service;

import com.mok.mokbackend.model.*;
import com.mok.mokbackend.repository.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OutfitService {

    private final UsuarioPrendaRepository usuarioPrendaRepository;
    private final OutfitRepository outfitRepository;
    private final UsuarioRepository usuarioRepository;

    public OutfitService(
            UsuarioPrendaRepository usuarioPrendaRepository,
            OutfitRepository outfitRepository,
            UsuarioRepository usuarioRepository
    ){
        this.usuarioPrendaRepository = usuarioPrendaRepository;
        this.outfitRepository = outfitRepository;
        this.usuarioRepository = usuarioRepository;
    }

    public Outfit generarOutfitRandom(Long usuarioId, TipoOutfit tipo){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow();

        List<UsuarioPrenda> armario =
                usuarioPrendaRepository.findByUsuarioId(usuarioId);

        Outfit outfit = new Outfit();
        outfit.setUsuario(usuario);
        outfit.setTipo(tipo);

        List<UsuarioPrenda> seleccion = new ArrayList<>();
        Random random = new Random();

        if(tipo == TipoOutfit.PARTES){
            seleccion.add(randomPorTipo(armario, TipoPrenda.ARRIBA));
            seleccion.add(randomPorTipo(armario, TipoPrenda.ABAJO));
            seleccion.add(randomPorTipo(armario, TipoPrenda.CALZADO));
            seleccion.add(randomPorTipo(armario, TipoPrenda.ACCESORIO));
        } else {
            seleccion.add(randomPorTipo(armario, TipoPrenda.VESTIDO));
            seleccion.add(randomPorTipo(armario, TipoPrenda.CALZADO));
            seleccion.add(randomPorTipo(armario, TipoPrenda.ACCESORIO));
        }

        outfit.setPrendas(seleccion);

        return outfitRepository.save(outfit);
    }

    private UsuarioPrenda randomPorTipo(List<UsuarioPrenda> armario, TipoPrenda tipo){

        List<UsuarioPrenda> filtradas = armario.stream()
                .filter(up -> up.getPrenda().getTipo() == tipo)
                .toList();

        if(filtradas.isEmpty()){
            throw new RuntimeException("No hay prendas de tipo: " + tipo);
        }

        return filtradas.get(new Random().nextInt(filtradas.size()));
    }

    public List<Outfit> obtenerOutfitsPorUsuario(Long usuarioId){
        return outfitRepository.findByUsuarioId(usuarioId);
    }

    public void eliminarOutfit(Long id){
        outfitRepository.deleteById(id);
    }
}