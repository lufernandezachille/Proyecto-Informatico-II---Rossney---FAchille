package com.mok.mokbackend.service;

import com.mok.mokbackend.model.*;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
public class OutfitService {

    private final PrendaUsuarioService prendaUsuarioService;
    private final List<Outfit> outfits = new ArrayList<>();
    private final Random random = new Random();

    public OutfitService(PrendaUsuarioService prendaUsuarioService) {
        this.prendaUsuarioService = prendaUsuarioService;
    }

    public Outfit generarOutfit(Long usuarioId, String tipo) {

        List<PrendaUsuario> prendas = prendaUsuarioService.obtenerPorUsuario(usuarioId);
        List<PrendaUsuario> resultado = new ArrayList<>();

        if (tipo.equals("PARTES")) {

            agregar(resultado, prendas, TipoPrenda.ACCESORIO);
            agregar(resultado, prendas, TipoPrenda.ARRIBA);
            agregar(resultado, prendas, TipoPrenda.ABAJO);
            agregar(resultado, prendas, TipoPrenda.CALZADO);
        }

        if (tipo.equals("VESTIDO")) {

            agregar(resultado, prendas, TipoPrenda.ACCESORIO);
            agregar(resultado, prendas, TipoPrenda.VESTIDO);
            agregar(resultado, prendas, TipoPrenda.CALZADO);
        }

        Outfit outfit = new Outfit();
        outfit.setId((long) (outfits.size() + 1));
        outfit.setUsuarioId(usuarioId);
        outfit.setTipo(tipo);
        outfit.setPrendas(resultado);

        outfits.add(outfit);

        return outfit;
    }

    private void agregar(List<PrendaUsuario> resultado,
                         List<PrendaUsuario> prendas,
                         TipoPrenda tipo) {

        List<PrendaUsuario> filtradas = prendas.stream()
                .filter(p -> p.getPrenda() != null && p.getPrenda().getTipo() == tipo)
                .toList();

        if (!filtradas.isEmpty()) {
            resultado.add(filtradas.get(random.nextInt(filtradas.size())));
        }
    }

    public List<Outfit> obtenerPorUsuario(Long usuarioId) {
        return outfits.stream()
                .filter(o -> o.getUsuarioId().equals(usuarioId))
                .toList();
    }
}