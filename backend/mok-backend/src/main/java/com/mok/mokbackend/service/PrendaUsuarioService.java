package com.mok.mokbackend.service;

import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.model.PrendaUsuario;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PrendaUsuarioService {

    private final List<PrendaUsuario> prendas = new ArrayList<>();
    private final PrendaService prendaService;

    public PrendaUsuarioService(PrendaService prendaService) {
        this.prendaService = prendaService;
    }

    public PrendaUsuario agregar(Long usuarioId, Long prendaId) {

        Prenda prenda = prendaService.buscarPorId(prendaId);

        if (prenda == null) {
            throw new RuntimeException("Prenda no existe");
        }

        PrendaUsuario pu = new PrendaUsuario();
        pu.setId((long) (prendas.size() + 1));
        pu.setUsuarioId(usuarioId);
        pu.setPrenda(prenda);

        prendas.add(pu);

        return pu;
    }

    public List<PrendaUsuario> obtenerPorUsuario(Long usuarioId) {
        return prendas.stream()
                .filter(p -> p.getUsuarioId().equals(usuarioId))
                .collect(Collectors.toList());
    }
}