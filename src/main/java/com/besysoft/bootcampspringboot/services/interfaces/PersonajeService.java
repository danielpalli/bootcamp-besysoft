package com.besysoft.bootcampspringboot.services.interfaces;

import com.besysoft.bootcampspringboot.dominio.Personaje;

import java.util.Optional;

public interface PersonajeService {
    Iterable<Personaje> obtenerPersonajes();
    Personaje altaPersonaje(Personaje personaje);
    Optional<Personaje> obtenerPersonajePorId(Long id);
    Iterable<Personaje> obtenerPersonajesPorEdad(Integer desde, Integer hasta);
    Optional<Personaje> actualizarPersonaje(Long id, Personaje personaje);
    Optional<Personaje> obtenerPersonajePorNombre(String nombre);
}
