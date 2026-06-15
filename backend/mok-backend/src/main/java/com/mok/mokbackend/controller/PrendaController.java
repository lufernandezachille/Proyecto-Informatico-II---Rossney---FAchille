package com.mok.mokbackend.controller;

import com.mok.mokbackend.model.Prenda;
import com.mok.mokbackend.model.TipoPrenda;
import com.mok.mokbackend.service.PrendaService;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/prendas")
@CrossOrigin(origins="*")
public class PrendaController {

    private final PrendaService prendaService;

    public PrendaController(PrendaService prendaService){
        this.prendaService=prendaService;
    }

    @GetMapping
    public List<Prenda> obtener(){
        return prendaService.obtenerTodas();
    }

    @PostMapping
    public Prenda crear(@RequestBody Prenda prenda){
        return prendaService.crearPrenda(prenda);
    }

    @GetMapping("/tipo/{tipo}")
    public List<Prenda> porTipo(
            @PathVariable TipoPrenda tipo
    ){
        return prendaService.obtenerPorTipo(tipo);
    }
}