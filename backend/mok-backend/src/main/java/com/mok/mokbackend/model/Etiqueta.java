package com.mok.mokbackend.model;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="etiquetas")
public class Etiqueta {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @ManyToMany(mappedBy="etiquetas")
    private List<Prenda> prendas;
    public Etiqueta(){
    }

    public Etiqueta(String nombre){
        this.nombre=nombre;
    }
    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public List<Prenda> getPrendas(){
        return prendas;
    }
    public void setPrendas(List<Prenda> prendas){
        this.prendas = prendas;
    }
}
