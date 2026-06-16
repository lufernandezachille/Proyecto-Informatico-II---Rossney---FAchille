package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.UsuarioPrenda;
import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.service.UsuarioPrendaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/armario")
@CrossOrigin(origins="*")
public class UsuarioPrendaController {

    private final UsuarioPrendaService service;

    public UsuarioPrendaController(
            UsuarioPrendaService service
    ){
        this.service=service;
    }

    @PostMapping("/{usuarioId}/agregar/{prendaId}")
    public UsuarioPrenda agregar(
            @PathVariable Long usuarioId,
            @PathVariable Long prendaId
    ){
        return service.agregarPrenda(usuarioId, prendaId);
    }

    @GetMapping("/{usuarioId}")
    public List<UsuarioPrenda> verArmario(
            @PathVariable Long usuarioId
    ){
        return service.obtenerArmario(usuarioId);
    }

    @GetMapping("/{usuarioId}/prendas")
    public List<Prenda> prendasDelUsuario(@PathVariable Long usuarioId){
        return service.obtenerPrendasDelUsuario(usuarioId);
    }

    @DeleteMapping("/{usuarioId}/quitar/{prendaId}")
    public void quitar(
            @PathVariable Long usuarioId,
            @PathVariable Long prendaId
    ){
        service.quitarPrenda(usuarioId, prendaId);
    }
}