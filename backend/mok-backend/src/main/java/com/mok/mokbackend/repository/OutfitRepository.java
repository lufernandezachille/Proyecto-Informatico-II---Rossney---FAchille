package com.mok.mokbackend.repository;

import com.mok.mokbackend.model.Outfit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutfitRepository
        extends JpaRepository<Outfit,Long> {
    List<Outfit> findByUsuarioId(Long usuarioId);
}