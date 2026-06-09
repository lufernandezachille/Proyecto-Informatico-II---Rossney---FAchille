package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Outfit;
import com.mok.mokbackend.service.OutfitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/outfits")
public class OutfitController {

    private final OutfitService service;

    public OutfitController(OutfitService service) {
        this.service = service;
    }

    @PostMapping("/generar")
    public Outfit generar(@RequestParam Long usuarioId,
                          @RequestParam String tipo) {
        return service.generarOutfit(usuarioId, tipo);
    }

    @GetMapping("/usuario/{id}")
    public List<Outfit> obtener(@PathVariable Long id) {
        return service.obtenerPorUsuario(id);
    }
}