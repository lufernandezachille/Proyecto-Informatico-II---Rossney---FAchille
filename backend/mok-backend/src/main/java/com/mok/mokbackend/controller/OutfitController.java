package com.mok.mokbackend.controller;

import org.springframework.web.bind.annotation.*;
import com.mok.mokbackend.service.OutfitService;
import com.mok.mokbackend.model.Outfit;
import com.mok.mokbackend.model.TipoOutfit;

import java.util.List;

@RestController
@RequestMapping("/outfits")
@CrossOrigin("*")
public class OutfitController {

    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService){
        this.outfitService = outfitService;
    }

    @GetMapping("/random/{usuarioId}/{tipo}")
    public Outfit generar(@PathVariable Long usuarioId,
                          @PathVariable TipoOutfit tipo){
        return outfitService.generarOutfitRandom(usuarioId, tipo);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Outfit> porUsuario(@PathVariable Long usuarioId){
        return outfitService.obtenerOutfitsPorUsuario(usuarioId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        outfitService.eliminarOutfit(id);
    }
}