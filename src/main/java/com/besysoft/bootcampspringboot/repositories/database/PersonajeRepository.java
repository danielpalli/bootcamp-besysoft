package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface PersonajeRepository extends CrudRepository<Personaje, Long> {
    @Query("SELECT p FROM Personaje p WHERE p.nombre = ?1")
    Optional<Personaje> buscarPersonajePorNombre(String nombre);
    @Query("SELECT p FROM Personaje p WHERE p.edad >= ?1 AND p.edad <= ?2")
    Iterable<Personaje> buscarPersonajePorEdad(Integer desde, Integer hasta);
}
