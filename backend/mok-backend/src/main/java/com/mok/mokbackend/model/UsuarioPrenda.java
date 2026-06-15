package com.mok.mokbackend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="usuario_prenda")
public class UsuarioPrenda {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="prenda_id")
    private Prenda prenda;
    private boolean propia;
    private String imagenPersonal;

    public UsuarioPrenda(){
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    public void setPrenda(Prenda prenda) {
        this.prenda = prenda;
    }
    public void setPropia(boolean propia) {
        this.propia = propia;
    }
    public Usuario getUsuario() {
        return usuario;
    }
    public Prenda getPrenda() {
        return prenda;
    }
    public boolean isPropia() {
        return propia;
    }
    public String getImagenPersonal() {
        return imagenPersonal;
    }
    public void setImagenPersonal(String imagenPersonal) {
        this.imagenPersonal = imagenPersonal;
    }
}