package com.mok.mokbackend.service;

import com.mok.mokbackend.model.Outfit;
import com.mok.mokbackend.model.Usuario;
import com.mok.mokbackend.model.UsuarioPrenda;
import com.mok.mokbackend.model.TipoOutfit;
import com.mok.mokbackend.model.TipoPrenda;

import com.mok.mokbackend.repository.OutfitRepository;
import com.mok.mokbackend.repository.UsuarioPrendaRepository;
import com.mok.mokbackend.repository.UsuarioRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OutfitService {

    private final UsuarioPrendaRepository usuarioPrendaRepository;
    private final UsuarioRepository usuarioRepository;
    private final OutfitRepository outfitRepository;

    public OutfitService(
            UsuarioPrendaRepository usuarioPrendaRepository,
            UsuarioRepository usuarioRepository,
            OutfitRepository outfitRepository
    ) {
        this.usuarioPrendaRepository = usuarioPrendaRepository;
        this.usuarioRepository = usuarioRepository;
        this.outfitRepository = outfitRepository;
    }

    public Outfit generarOutfitBasico(Long usuarioId){

        Usuario usuario = usuarioRepository.findById(usuarioId)
                .orElseThrow(() -> new RuntimeException("Usuario no encontrado"));

        List<UsuarioPrenda> armario = usuarioPrendaRepository.findByUsuarioId(usuarioId);

        List<UsuarioPrenda> arriba = armario.stream()
                .filter(p -> p.getPrenda().getTipo() == TipoPrenda.ARRIBA)
                .toList();

        List<UsuarioPrenda> abajo = armario.stream()
                .filter(p -> p.getPrenda().getTipo() == TipoPrenda.ABAJO)
                .toList();

        List<UsuarioPrenda> calzado = armario.stream()
                .filter(p -> p.getPrenda().getTipo() == TipoPrenda.CALZADO)
                .toList();

        if(arriba.isEmpty() || abajo.isEmpty() || calzado.isEmpty()){
            throw new RuntimeException("No tenés suficientes prendas para generar outfit");
        }

        UsuarioPrenda p1 = arriba.get(0);
        UsuarioPrenda p2 = abajo.get(0);
        UsuarioPrenda p3 = calzado.get(0);

        Outfit outfit = new Outfit(
                usuario,
                TipoOutfit.PARTES,
                List.of(p1, p2, p3)
        );

        return outfitRepository.save(outfit);
    }
}