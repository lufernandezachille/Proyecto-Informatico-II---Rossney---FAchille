package com.mok.mokbackend.model;

import java.util.List;

public class Outfit {

    private Long id;
    private Long usuarioId;
    private String tipo;
    private List<PrendaUsuario> prendas;

    public Outfit() {}

    public Outfit(Long id, Long usuarioId, String tipo, List<PrendaUsuario> prendas) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.tipo = tipo;
        this.prendas = prendas;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<PrendaUsuario> getPrendas() { return prendas; }
    public void setPrendas(List<PrendaUsuario> prendas) { this.prendas = prendas; }
}