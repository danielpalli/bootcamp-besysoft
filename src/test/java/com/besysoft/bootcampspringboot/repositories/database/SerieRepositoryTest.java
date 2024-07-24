package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Serie;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@DataJpaTest
class SerieRepositoryTest {

    @Autowired
    private SerieRepository serieRepository;
    @BeforeEach
    void setUp() {
        serieRepository.save(DatosDummy.getSerieLosJuegosDelHambre());
        serieRepository.save(DatosDummy.getSerieLosJuegosDelHambre2());
        serieRepository.save(DatosDummy.getSerieLosJuegosDelHambre3());
    }

    @AfterEach
    void tearDown() {
        serieRepository.deleteAll();
    }

    @Test
    void obtenerSeriePorNombre() {
        String testUno = "Los Juegos del Hambre";

        Optional<Serie> oSerie = serieRepository.obtenerSeriePorNombre(DatosDummy.getSerieLosJuegosDelHambre().getTitulo());

        assertTrue(oSerie.isPresent());
        assertEquals(testUno, oSerie.get().getTitulo());
    }

    @Test
    void obtenerSeriePorCalificacion() {
        Integer desde = 1;
        Integer hasta = 3;

        List<Serie> series = (List<Serie>) serieRepository.obtenerSeriePorCalificacion(desde, hasta);

        assertEquals(1, series.size());
    }

    @Test
    void obtenerSeriePorFecha() {
        Long desde = 2012L;
        Long hasta = 2014L;

        List<Serie> series = (List<Serie>) serieRepository.obtenerSeriePorFecha(desde, hasta);

        assertEquals(1, series.size());
    }

    @Test
    void obtenerSeriesPorTitulo() {
        String titulo = "Los Juegos del Hambre";

        List<Serie> series = (List<Serie>) serieRepository.obtenerSeriesPorTitulo(titulo);

        assertEquals(3, series.size());
    }

}