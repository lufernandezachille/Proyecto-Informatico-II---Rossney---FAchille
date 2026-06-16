package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Favorito;
import com.mok.mokbackend.service.FavoritoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/favoritos")
@CrossOrigin(origins="*")
public class FavoritoController {

    private final FavoritoService service;

    public FavoritoController(FavoritoService service){
        this.service = service;
    }

    @PostMapping("/{usuarioId}/{outfitId}")
    public Favorito agregar(@PathVariable Long usuarioId,
                            @PathVariable Long outfitId){
        return service.agregar(usuarioId, outfitId);
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Favorito> listar(@PathVariable Long usuarioId){
        return service.listar(usuarioId);
    }

    @DeleteMapping("/{id}")
    public void eliminar(@PathVariable Long id){
        service.eliminar(id);
    }
}