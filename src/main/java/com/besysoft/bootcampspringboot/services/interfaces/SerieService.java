package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.Serie;

import java.util.Optional;

public interface SerieService {
    Iterable<Serie> obtenerCatalogo();
    Optional<Serie> obtenerSeriePorId(Long id);
    Serie nuevaSerie(Serie serie);
    Optional<Serie> actualizarSerie(Long id, Serie serie);
    Iterable<Serie> obtenerSeriePorCalificacion(Integer desde, Integer hasta);
    Iterable<Serie> obtenerSeriePorFecha(Long desde, Long hasta);
    Iterable<Serie> obtenerSeriesPorTitulo(String titulo);
    Iterable<Serie> obtenerSeriePorGenero(String genero);
}
