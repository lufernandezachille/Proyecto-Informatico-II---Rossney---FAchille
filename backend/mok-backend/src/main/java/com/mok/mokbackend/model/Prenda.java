package com.mok.mokbackend.model;


import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name="prendas")
public class Prenda {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String imagen;
    @Enumerated(EnumType.STRING)
    private TipoPrenda tipo;
    @ManyToMany
    @JoinTable(
            name="prenda_etiqueta",
            joinColumns=@JoinColumn(name="prenda_id"),
            inverseJoinColumns=@JoinColumn(name="etiqueta_id")
    )
    private List<Etiqueta> etiquetas;

    public Prenda(){

    }

    public Prenda(String nombre, TipoPrenda tipo){
        this.nombre=nombre;
        this.tipo=tipo;
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
    public String getImagen(){
        return imagen;
    }
    public void setImagen(String imagen){
        this.imagen = imagen;
    }
    public TipoPrenda getTipo(){
        return tipo;
    }
    public void setTipo(TipoPrenda tipo){
        this.tipo = tipo;
    }
    public List<Etiqueta> getEtiquetas(){
        return etiquetas;
    }
    public void setEtiquetas(List<Etiqueta> etiquetas){
        this.etiquetas = etiquetas;
    }
}