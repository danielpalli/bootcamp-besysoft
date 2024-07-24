package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.dominio.Serie;
import com.besysoft.bootcampspringboot.repositories.database.SerieRepository;
import com.besysoft.bootcampspringboot.services.interfaces.SerieService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@ConditionalOnProperty(name = "app.type-bean", havingValue = "memory")
public class SerieServiceImp implements SerieService {
    private final SerieRepository serieRepository;
    public SerieServiceImp(SerieRepository serieRepository) {
        this.serieRepository = serieRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Serie> obtenerCatalogo() {
        return this.serieRepository.findAll();
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Serie> obtenerSeriePorId(Long id) {
        return this.serieRepository.findById(id);
    }
    @Override
    @Transactional(readOnly = false)
    public Serie nuevaSerie(Serie serie) {
        Optional<Serie> existeSerie = this.serieRepository.obtenerSeriePorNombre(serie.getTitulo());

        if (existeSerie.isPresent()) {
            throw new RuntimeException("La serie ya existe");
        }

        return this.serieRepository.save(serie);
    }
    @Override
    @Transactional(readOnly = false)
    public Optional<Serie> actualizarSerie(Long id, Serie serie) {
        Optional<Serie> oSerie = this.serieRepository.findById(id);

        if (oSerie.isEmpty()) {
            throw new RuntimeException("No se encontró el id");
        }

        oSerie.get().setTitulo(serie.getTitulo());
        oSerie.get().setFecha(serie.getFecha());
        oSerie.get().setCalificacion(serie.getCalificacion());
        oSerie.get().setPersonajes(serie.getPersonajes());
        return Optional.of(this.serieRepository.save(oSerie.get()));
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Serie> obtenerSeriePorCalificacion(Integer desde, Integer hasta) {
        if (desde > hasta) {
            return null;
        }

        Iterable<Serie> series = this.serieRepository.obtenerSeriePorCalificacion(desde, hasta);

        if (series == null) {
            return null;
        }

        return series;
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Serie> obtenerSeriePorFecha(Long desde, Long hasta) {
        if (desde > hasta) {
            return null;
        }

        Iterable<Serie> series = this.serieRepository.obtenerSeriePorFecha(desde, hasta);

        if (series == null) {
            return null;
        }

        return series;
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Serie> obtenerSeriesPorTitulo(String titulo) {
        Iterable<Serie> series = this.serieRepository.obtenerSeriesPorTitulo(titulo);

        if (series == null) {
            return null;
        }

        return series;
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Serie> obtenerSeriePorGenero(String genero) {
        Iterable<Serie> series = this.serieRepository.obtenerSeriePorGenero(genero);

        if (series == null) {
            return null;
        }

        return series;
    }
}
