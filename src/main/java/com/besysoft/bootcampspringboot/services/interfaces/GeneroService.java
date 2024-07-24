package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.Genero;

import java.util.Optional;

public interface GeneroService {
    Iterable<Genero> obtenerGeneros();
    Genero nuevoGenero(Genero genero);
    Optional<Genero> obtenerGeneroPorId(Long id);
    Optional<Genero> actualizarGenero(Long id, Genero genero);
}
