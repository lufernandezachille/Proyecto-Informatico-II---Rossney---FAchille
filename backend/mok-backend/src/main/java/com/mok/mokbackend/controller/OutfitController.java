package com.mok.mokbackend.controller;

import org.springframework.web.bind.annotation.*;
import com.mok.mokbackend.service.OutfitService;
import com.mok.mokbackend.model.Outfit;
import com.mok.mokbackend.model.TipoOutfit;

import java.util.List;

@RestController
@RequestMapping("/outfits")
@CrossOrigin(origins="*")
public class OutfitController {

    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService){
        this.outfitService = outfitService;
    }

    @GetMapping("/random/{usuarioId}/{tipo}")
    public Outfit generarRandom(
            @PathVariable Long usuarioId,
            @PathVariable TipoOutfit tipo
    ){
        return outfitService.generarOutfitRandom(usuarioId, tipo);
    }

    @PostMapping("/guardar")
    public Outfit guardar(@RequestBody Outfit outfit){
        return outfitService.guardarOutfit(outfit);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Outfit> porUsuario(@PathVariable Long usuarioId){
        return outfitService.obtenerOutfitsPorUsuario(usuarioId);
    }
}
