package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.dominio.Genero;

import com.besysoft.bootcampspringboot.exepciones.GeneroExistException;
import com.besysoft.bootcampspringboot.repositories.database.GeneroRepository;
import com.besysoft.bootcampspringboot.services.interfaces.GeneroService;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@ConditionalOnProperty(name = "app.type-bean", havingValue = "memory")
public class GeneroServiceImp implements GeneroService {
    private final GeneroRepository generoRepository;

    public GeneroServiceImp(GeneroRepository generoRepository) {
        this.generoRepository = generoRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public Iterable<Genero> obtenerGeneros() {
        return this.generoRepository.findAll();
    }

    @Override
    @Transactional(readOnly = false)
    public Genero nuevoGenero(Genero genero) {
        Optional<Genero> oGenero = this.generoRepository.buscarGeneroPorNombre(genero.getGenero());

        if (oGenero.isPresent()) {
            throw new GeneroExistException("El genero ya existe", new RuntimeException("Causa Original")
            );
        }

        return this.generoRepository.save(genero);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Genero> obtenerGeneroPorId(Long id) {
        return this.generoRepository.findById(id);
    }

    @Override
    @Transactional(readOnly = false)
    public Optional<Genero> actualizarGenero(Long id, Genero genero) {
        Optional<Genero> oGenero = this.generoRepository.findById(id);

        if (oGenero.isEmpty()) {
            throw new GeneroExistException("No se encontró el id", new RuntimeException("Causa"));
        }

        oGenero.get().setGenero(genero.getGenero());
        return Optional.of(this.generoRepository.save(oGenero.get()));
    }
}
