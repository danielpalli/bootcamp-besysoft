package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.dominio.Serie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface SerieRepository extends CrudRepository<Serie, Long> {
    @Query("SELECT s FROM Serie s WHERE s.titulo = ?1")
    Optional<Serie> obtenerSeriePorNombre(String titulo);
    @Query("SELECT s FROM Serie s WHERE s.calificacion >= ?1 AND s.calificacion <= ?2")
    Iterable<Serie> obtenerSeriePorCalificacion(Integer desde, Integer hasta);
    @Query("SELECT s FROM Serie s WHERE s.fecha >= ?1 AND s.fecha <= ?2")
    Iterable<Serie> obtenerSeriePorFecha(Long desde, Long hasta);
    @Query("SELECT s FROM Serie s WHERE s.titulo LIKE %?1%")
    Iterable<Serie> obtenerSeriesPorTitulo(String titulo);
    @Query("SELECT s FROM Serie s WHERE s.genero = ?1")
    Iterable<Serie> obtenerSeriePorGenero(String genero);
}
