package com.mok.mokbackend;

import com.mok.mokbackend.model.*;
import com.mok.mokbackend.repository.PrendaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {
    private final PrendaRepository prendaRepository;

    public DataInitializer(PrendaRepository prendaRepository){
        this.prendaRepository = prendaRepository;
    }

    @Override
    public void run(String... args){
        if(prendaRepository.count() == 0){
            prendaRepository.save(
                    new Prenda(
                            "Remera blanca",
                            TipoPrenda.ARRIBA,
                            CategoriaPrenda.REMERA
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Camisa negra",
                            TipoPrenda.ARRIBA,
                            CategoriaPrenda.REMERA
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Jean azul",
                            TipoPrenda.ABAJO,
                            CategoriaPrenda.PANTALON
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Pantalón negro",
                            TipoPrenda.ABAJO,
                            CategoriaPrenda.PANTALON
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Zapatillas blancas",
                            TipoPrenda.CALZADO,
                            CategoriaPrenda.CALZADO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Gorra",
                            TipoPrenda.ACCESORIO,
                            CategoriaPrenda.ACCESORIO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Vestido negro",
                            TipoPrenda.VESTIDO,
                            CategoriaPrenda.VESTIDO
                    )
            );
        }
    }
}