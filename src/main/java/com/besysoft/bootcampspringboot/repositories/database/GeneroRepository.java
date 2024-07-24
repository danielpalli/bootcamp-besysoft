package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.dominio.Genero;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
public interface GeneroRepository extends CrudRepository<Genero, Long> {
    @Query("SELECT g FROM Genero g WHERE g.genero = ?1")
    Optional<Genero> buscarGeneroPorNombre(String genero);
}
