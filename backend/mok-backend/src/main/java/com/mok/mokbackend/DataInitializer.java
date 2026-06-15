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
                            TipoPrenda.ARRIBA
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Camisa negra",
                            TipoPrenda.ARRIBA
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Jean azul",
                            TipoPrenda.ABAJO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Pantalón negro",
                            TipoPrenda.ABAJO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Zapatillas blancas",
                            TipoPrenda.CALZADO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Gorra",
                            TipoPrenda.ACCESORIO
                    )
            );
            prendaRepository.save(
                    new Prenda(
                            "Vestido negro",
                            TipoPrenda.VESTIDO
                    )
            );
        }
    }
}