package com.mok.mokbackend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.util.List;

@Entity
@Table(name="outfits")
public class Outfit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;

    @Enumerated(EnumType.STRING)
    private TipoOutfit tipo;

    @ManyToMany
    @JoinTable(
            name="outfit_prenda",
            joinColumns=@JoinColumn(name="outfit_id"),
            inverseJoinColumns=@JoinColumn(name="usuario_prenda_id")
    )
    @JsonIgnoreProperties({"usuario"})
    private List<UsuarioPrenda> prendas;

    public Outfit(){}

    public Long getId() { return id; }
    public Usuario getUsuario() { return usuario; }
    public TipoOutfit getTipo() { return tipo; }
    public List<UsuarioPrenda> getPrendas() { return prendas; }
    public void setUsuario(Usuario usuario) { this.usuario = usuario; }
    public void setTipo(TipoOutfit tipo) { this.tipo = tipo; }
    public void setPrendas(List<UsuarioPrenda> prendas) { this.prendas = prendas; }
}