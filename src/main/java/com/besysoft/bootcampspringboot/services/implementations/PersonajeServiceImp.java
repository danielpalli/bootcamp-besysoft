package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.repositories.database.PersonajeRepository;
import com.besysoft.bootcampspringboot.services.interfaces.PersonajeService;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
@Service
@ConditionalOnProperty(name = "app.type-bean", havingValue = "memory")
public class PersonajeServiceImp implements PersonajeService {
    private final PersonajeRepository personajeRepository;
    public PersonajeServiceImp(PersonajeRepository personajeRepository) {
        this.personajeRepository = personajeRepository;
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Personaje> obtenerPersonajes() {
        return this.personajeRepository.findAll();
    }
    @Override
    @Transactional(readOnly = false)
    public Personaje altaPersonaje(Personaje personaje) {
        Optional<Personaje> existePersonaje = this.personajeRepository.buscarPersonajePorNombre(personaje.getNombre());

        if (existePersonaje.isPresent()) {
            throw new RuntimeException("El personaje ya existe");
        }

        return this.personajeRepository.save(personaje);
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Personaje> obtenerPersonajePorId(Long id) {
        return this.personajeRepository.findById(id);
    }
    @Override
    @Transactional(readOnly = true)
    public Iterable<Personaje> obtenerPersonajesPorEdad(Integer desde, Integer hasta) {
        if (desde > hasta) {
            return null;
        }

        Iterable<Personaje> personajes = this.personajeRepository.buscarPersonajePorEdad(desde, hasta);

        if (personajes == null) {
            return null;
        }

        return personajes;
    }
    @Override
    @Transactional(readOnly = false)
    public Optional<Personaje> actualizarPersonaje(Long id, Personaje personaje) {
        Optional<Personaje> oPersonaje = this.personajeRepository.findById(id);

        if (oPersonaje.isEmpty()) {
            throw new RuntimeException("No se encontró el id");
        }

        oPersonaje.get().setNombre(personaje.getNombre());
        oPersonaje.get().setEdad(personaje.getEdad());
        oPersonaje.get().setPeso(personaje.getPeso());
        oPersonaje.get().setHistoria(personaje.getHistoria());
        oPersonaje.get().setSeries(personaje.getSeries());
        return Optional.of(this.personajeRepository.save(oPersonaje.get()));
    }
    @Override
    @Transactional(readOnly = true)
    public Optional<Personaje> obtenerPersonajePorNombre(String nombre) {
        return this.personajeRepository.buscarPersonajePorNombre(nombre);
    }
}
