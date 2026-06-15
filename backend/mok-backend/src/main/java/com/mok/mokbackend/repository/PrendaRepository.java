package com.mok.mokbackend.repository;

import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.model.TipoPrenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PrendaRepository
        extends JpaRepository<Prenda,Long> {

    List<Prenda> findByTipo(TipoPrenda tipo);
}