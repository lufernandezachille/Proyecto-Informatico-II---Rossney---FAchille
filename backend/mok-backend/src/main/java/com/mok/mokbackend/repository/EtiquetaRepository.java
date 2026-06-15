package com.mok.mokbackend.repository;

import com.mok.mokbackend.model.Etiqueta;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EtiquetaRepository
        extends JpaRepository<Etiqueta, Long> {
}