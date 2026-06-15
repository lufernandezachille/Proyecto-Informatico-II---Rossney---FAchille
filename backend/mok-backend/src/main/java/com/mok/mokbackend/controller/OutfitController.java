package com.mok.mokbackend.controller;

import org.springframework.web.bind.annotation.*;
import com.mok.mokbackend.service.OutfitService;
import com.mok.mokbackend.model.Outfit;

@RestController
@RequestMapping("/outfits")
@CrossOrigin(origins="*")
public class OutfitController {

    private final OutfitService outfitService;

    public OutfitController(OutfitService outfitService){
        this.outfitService = outfitService;
    }

    @PostMapping("/generar/{usuarioId}")
    public Outfit generar(@PathVariable Long usuarioId){
        return outfitService.generarOutfitBasico(usuarioId);
    }
}
