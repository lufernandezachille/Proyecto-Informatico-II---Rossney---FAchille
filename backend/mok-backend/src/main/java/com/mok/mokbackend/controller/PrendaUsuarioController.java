package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.PrendaUsuario;
import com.mok.mokbackend.service.PrendaUsuarioService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armario")
public class PrendaUsuarioController {

    private final PrendaUsuarioService service;

    public PrendaUsuarioController(PrendaUsuarioService service) {
        this.service = service;
    }

    @GetMapping("/usuario/{id}")
    public List<PrendaUsuario> obtener(@PathVariable Long id) {
        return service.obtenerPorUsuario(id);
    }

    @PostMapping
    public PrendaUsuario agregar(@RequestParam Long usuarioId,
                                 @RequestParam Long prendaId) {
        return service.agregar(usuarioId, prendaId);
    }
}