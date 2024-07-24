package com.besysoft.bootcampspringboot.repositories.memory;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.repositories.memory.GeneroRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.besysoft.bootcampspringboot.utilidades.GenerarDatos.datosGenero;

@Repository
public class GeneroRepositoryMemory implements GeneroRepository {
    private List<Genero> generos;

    public GeneroRepositoryMemory() {
        this.generos = datosGenero();
    }
    @Override
    public Iterable<Genero> obtenerGeneros() {
        return this.generos;
    }

    @Override
    public Genero nuevoGenero(Genero genero) {

        genero.setId((long) (this.generos.size() + 1));
        this.generos.add(genero);

        return genero;
    }

    @Override
    public Optional<Genero> obtenerGeneroPorId(Long id) {
        return this.generos.stream().filter(genero -> genero.getId().equals(id)).findFirst();
    }

    @Override
    public Optional<Genero> actualizarGenero(Long id, Genero genero) {
        Optional<Genero> oGenero = this.obtenerGeneroPorId(id);

        if (oGenero.isEmpty()) {
            return Optional.empty();
        }

        Genero generoActualizado = oGenero.get();
        generoActualizado.setGenero(genero.getGenero());
//        generoActualizado.setSeries(genero.getSeries());
        return Optional.of(generoActualizado);
    }


}
