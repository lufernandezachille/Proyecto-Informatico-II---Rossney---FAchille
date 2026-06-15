package com.mok.mokbackend.repository;

import com.mok.mokbackend.model.UsuarioPrenda;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioPrendaRepository
        extends JpaRepository<UsuarioPrenda,Long> {

    List<UsuarioPrenda> findByUsuarioId(Long usuarioId);
    boolean existsByUsuarioIdAndPrendaId(Long usuarioId, Long prendaId);
}