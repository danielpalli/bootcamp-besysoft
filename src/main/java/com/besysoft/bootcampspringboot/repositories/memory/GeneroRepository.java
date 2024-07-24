package com.besysoft.bootcampspringboot.repositories.memory;

import com.besysoft.bootcampspringboot.dominio.Genero;

import java.util.Optional;

public interface GeneroRepository {
    Iterable<Genero> obtenerGeneros();
    Genero nuevoGenero (Genero genero);
    Optional<Genero> obtenerGeneroPorId(Long id);
    Optional<Genero> actualizarGenero(Long id, Genero genero);
}
