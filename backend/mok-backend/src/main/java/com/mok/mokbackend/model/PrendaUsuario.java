package com.mok.mokbackend.model;

public class PrendaUsuario {

    private Long id;
    private Long usuarioId;
    private Prenda prenda;
    private String imagenUrl;

    public PrendaUsuario() {}

    public PrendaUsuario(Long id, Long usuarioId, Prenda prenda, String imagenUrl) {
        this.id = id;
        this.usuarioId = usuarioId;
        this.prenda = prenda;
        this.imagenUrl = imagenUrl;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Long getUsuarioId() { return usuarioId; }
    public void setUsuarioId(Long usuarioId) { this.usuarioId = usuarioId; }

    public Prenda getPrenda() { return prenda; }
    public void setPrenda(Prenda prenda) { this.prenda = prenda; }

    public String getImagenUrl() { return imagenUrl; }
    public void setImagenUrl(String imagenUrl) { this.imagenUrl = imagenUrl; }
}