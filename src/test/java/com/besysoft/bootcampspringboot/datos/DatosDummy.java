package com.besysoft.bootcampspringboot.datos;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.dominio.Serie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DatosDummy {
    public static Genero getGeneroComedia() {
        return new Genero(null, "Comedia");
    }
    public static Genero getGeneroDrama() {
        return new Genero(null, "Drama");
    }
    public static Genero getGeneroTerror() {
        return new Genero(null, "Terror");
    }
    public static List<Genero> getListaGeneros() {
        return new ArrayList<>(Arrays.asList(
            new Genero(1L, "Comedia"),
            new Genero(2L, "Drama"),
            new Genero(3L, "Terror")
        ));
    }

    public static Personaje getPersonajeThor() {
        return new Personaje(null, "Thor", 40, 120D, "Asgard habitante");
    }

    public static Personaje getPersonajeIronMan() {
        return new Personaje(null , "IronMan", 50, 122D, "Tierra habitante");
    }

    public static Personaje getPersonajeHulk() {
        return new Personaje(null , "Hulk", 40, 125D, "Tierra habitante");
    }

    public static List<Personaje> getListaPersonajes() {
        return new ArrayList<>(Arrays.asList(
            new Personaje(1L, "Thor", 40, 120D, "Asgard habitante"),
            new Personaje(2L, "IronMan", 50, 122D, "Tierra habitante"),
            new Personaje(3L, "Hulk", 40, 125D, "Tierra habitante")
        ));
    }

    public static Serie getSerieLosJuegosDelHambre() {
        return new Serie(null, "Los Juegos del Hambre", 2013L ,3);
    }

    public static Serie getSerieLosJuegosDelHambre2() {
        return new Serie(null, "Los Juegos del Hambre 2", 2015L ,4);
    }

    public static Serie getSerieLosJuegosDelHambre3() {
        return new Serie(null, "Los Juegos del Hambre 3", 2017L ,5);
    }

    public static List<Serie> getListaSeries() {
        return new ArrayList<>(Arrays.asList(
            new Serie(1L, "Los Juegos del Hambre", 23052013L ,3),
            new Serie(2L, "Los Juegos del Hambre 2", 23052015L ,4),
            new Serie(3L, "Los Juegos del Hambre 3", 23052017L ,5)
        ));
    }

}
