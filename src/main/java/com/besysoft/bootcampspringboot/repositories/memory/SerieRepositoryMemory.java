package com.besysoft.bootcampspringboot.repositories.memory;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Serie;
import com.besysoft.bootcampspringboot.repositories.memory.SerieRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.besysoft.bootcampspringboot.utilidades.GenerarDatos.datosSeries;
import static com.besysoft.bootcampspringboot.utilidades.GenerarDatos.datosGenero;

@Repository
public class SerieRepositoryMemory implements SerieRepository {
    private List<Serie> series;
    private List<Genero> generos;

    public SerieRepositoryMemory() {
        this.series = datosSeries();
        this.generos = datosGenero();
    }

    @Override
    public Iterable<Serie> obtenerCatalogo() {
        return this.series;
    }

    @Override
    public Optional<Serie> obtenerSeriePorId(Long id) {
        return this.series.stream().filter(serie -> serie.getId().equals(id)).findFirst();
    }

    @Override
    public Serie nuevaSerie(Serie serie) {
        serie.setId((long) (this.series.size() + 1));
        this.series.add(serie);

        return serie;
    }

    @Override
    public Optional<Serie> actualizarSerie(Long id, Serie serie) {
        Optional<Serie> oSerie = this.obtenerSeriePorId(id);

        if (oSerie.isEmpty()) {
            return Optional.empty();
        }

        Serie serieActualizada = oSerie.get();
        serieActualizada.setTitulo(serie.getTitulo());
        serieActualizada.setFecha(serie.getFecha());
        serieActualizada.setCalificacion(serie.getCalificacion());
//        serieActualizada.setPersonajes(serie.getPersonajes());
        return Optional.of(serieActualizada);
    }

    @Override
    public Iterable<Serie> obtenerSeriePorCalificacion(Integer desde, Integer hasta) {
        List<Serie> seriesFiltradas = new ArrayList<>();
        this.series.forEach(serie -> {
            if (serie.getCalificacion() >= desde && serie.getCalificacion() <= hasta) {
                seriesFiltradas.add(serie);
            }
        });
        return seriesFiltradas;
    }

    @Override
    public Iterable<Serie> obtenerSeriePorFecha(Long desde, Long hasta) {
        List<Serie> seriesFiltradas = new ArrayList<>();
        this.series.forEach(serie -> {
            if (serie.getFecha() >= desde && serie.getFecha() <= hasta) {
                seriesFiltradas.add(serie);
            }
        });
        return seriesFiltradas;
    }

    @Override
    public Iterable<Serie> obtenerSeriePorTitulo(String titulo) {
        List<Serie> seriesFiltradas = new ArrayList<>();
        this.series.forEach(serie -> {
            if (serie.getTitulo().contains(titulo)) {
                seriesFiltradas.add(serie);
            }
        });
        return seriesFiltradas;
    }

    @Override
    public Iterable<Serie> obtenerSeriePorGenero(String genero) {
        List<Serie> seriesFiltradas = new ArrayList<>();
//        for (Genero genero1 : generos) {
//            if (genero1.getGenero().toLowerCase().contains(genero.toLowerCase())) {
//                for (String serie : genero1.getSeries()) {
//                    for (Serie serie1 : series) {
//                        if (serie1.getTitulo().toLowerCase().contains(serie.toLowerCase())) seriesFiltradas.add(serie1);
//                    }
//                }
//            }
//        }
        return seriesFiltradas;
    }
}
