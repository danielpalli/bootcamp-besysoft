package com.besysoft.bootcampspringboot.repositories.memory;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.repositories.memory.PersonajeRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.besysoft.bootcampspringboot.utilidades.GenerarDatos.datosPersonajes;

@Repository
public class PersonajeRepositoryMemory implements PersonajeRepository {
    private List<Personaje> personajes;

    public PersonajeRepositoryMemory() {
        this.personajes = datosPersonajes();
    }

    @Override
    public Iterable<Personaje> obtenerPersonajes() {
        return this.personajes;
    }

    @Override
    public Personaje altaPersonaje(Personaje personaje) {

        personaje.setId((long) (this.personajes.size() + 1));
        this.personajes.add(personaje);

        return personaje;
    }

    @Override
    public Optional<Personaje> obtenerPersonajePorId(Long id) {
        return this.personajes.stream().filter(personaje -> personaje.getId().equals(id)).findFirst();
    }

    @Override
    public Iterable<Personaje> obtenerPersonajesPorEdad(Integer desde, Integer hasta) {
        List<Personaje> personajesFiltrados = new ArrayList<>();
        personajes.forEach(personaje -> {
            if (personaje.getEdad() >= desde && personaje.getEdad() <= hasta) {
                personajesFiltrados.add(personaje);
            }
        });
        return personajesFiltrados;
    }

    @Override
    public Optional<Personaje> actualizarPersonaje(Long id, Personaje personaje) {
        Optional<Personaje> oPersonaje = this.obtenerPersonajePorId(id);

        if (oPersonaje.isEmpty()) {
            return Optional.empty();
        }

        Personaje personajeActualizado = oPersonaje.get();
        personajeActualizado.setNombre(personaje.getNombre());
        personajeActualizado.setEdad(personaje.getEdad());
//        personajeActualizado.setSeries(personaje.getSeries());
        personajeActualizado.setPeso(personaje.getPeso());
        personajeActualizado.setHistoria(personaje.getHistoria());
        return Optional.of(personajeActualizado);
    }

    @Override
    public Optional<Personaje> obtenerPersonajePorNombre(String nombre) {
        return this.personajes.stream().filter(personaje -> personaje.getNombre().equals(nombre)).findFirst();
    }
}
