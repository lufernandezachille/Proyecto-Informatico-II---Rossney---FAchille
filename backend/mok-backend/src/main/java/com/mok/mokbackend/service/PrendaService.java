package com.mok.mokbackend.service;

import com.mok.mokbackend.model.Prenda;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PrendaService {

    private final List<Prenda> prendas = new ArrayList<>();

    public List<Prenda> obtenerTodas() {
        return prendas;
    }

    public Prenda agregar(Prenda prenda) {
        prenda.setId((long) (prendas.size() + 1));
        prendas.add(prenda);
        return prenda;
    }

    public Prenda buscarPorId(Long id) {
        return prendas.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}