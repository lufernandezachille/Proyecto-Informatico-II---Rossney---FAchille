package com.mok.mokbackend.model;

public class Prenda {

    private Long id;
    private String nombre;
    private TipoPrenda tipo;

    public Prenda() {}

    public Prenda(Long id, String nombre, TipoPrenda tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public TipoPrenda getTipo() { return tipo; }
    public void setTipo(TipoPrenda tipo) { this.tipo = tipo; }
}