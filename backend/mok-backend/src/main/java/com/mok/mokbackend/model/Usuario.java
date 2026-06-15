package com.mok.mokbackend.model;

import jakarta.persistence.*;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    @Column(unique=true)
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private Plan plan;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<UsuarioPrenda> prendas;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Outfit> outfits;
    @JsonIgnore
    @OneToMany(mappedBy="usuario")
    private List<Favorito> favoritos;

    public Usuario(){

    }

    public Usuario(String nombre, String email, String password){
        this.nombre=nombre;
        this.email=email;
        this.password=password;
        this.plan=Plan.GRATUITO;
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
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }
    public Plan getPlan(){
        return plan;
    }
    public void setPlan(Plan plan){
        this.plan = plan;
    }
    public List<UsuarioPrenda> getPrendas(){
        return prendas;
    }
    public void setPrendas(List<UsuarioPrenda> prendas){
        this.prendas = prendas;
    }
    public List<Outfit> getOutfits(){
        return outfits;
    }
    public void setOutfits(List<Outfit> outfits){
        this.outfits = outfits;
    }
    public List<Favorito> getFavoritos(){
        return favoritos;
    }
    public void setFavoritos(List<Favorito> favoritos){
        this.favoritos = favoritos;
    }
}