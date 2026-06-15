package com.mok.mokbackend.service;

import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.repository.PrendaRepository;
import org.springframework.stereotype.Service;
import com.mok.mokbackend.model.TipoPrenda;

import java.util.List;

@Service
public class PrendaService {
    private final PrendaRepository prendaRepository;

    public PrendaService(PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }

    // Traer todas las prendas para explorar
    public List<Prenda> obtenerTodas(){

        return prendaRepository.findAll();
    }

    // Crear una prenda general
    public Prenda crearPrenda(Prenda prenda){

        return prendaRepository.save(prenda);
    }

    public Prenda buscarPorId(Long id){

        return prendaRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Prenda no encontrada")
                );
    }

    public List<Prenda> obtenerPorTipo(TipoPrenda tipo){
        return prendaRepository.findByTipo(tipo);
    }
}