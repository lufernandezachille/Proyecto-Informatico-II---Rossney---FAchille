package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.service.PrendaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/prendas")
public class PrendaController {

    private final PrendaService service;

    public PrendaController(PrendaService service) {
        this.service = service;
    }

    @GetMapping
    public List<Prenda> obtenerTodas() {
        return service.obtenerTodas();
    }

    @PostMapping
    public Prenda agregar(@RequestBody Prenda prenda) {
        return service.agregar(prenda);
    }
}