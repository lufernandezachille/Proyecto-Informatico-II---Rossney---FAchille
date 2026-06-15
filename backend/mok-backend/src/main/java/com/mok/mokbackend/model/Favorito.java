package com.mok.mokbackend.model;


import jakarta.persistence.*;


@Entity
@Table(name="favoritos")
public class Favorito {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="usuario_id")
    private Usuario usuario;
    @ManyToOne
    @JoinColumn(name="outfit_id")
    private Outfit outfit;

    public Favorito(){

    }


}
