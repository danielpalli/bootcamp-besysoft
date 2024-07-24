package com.besysoft.bootcampspringboot.dominio;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "serie")
public class Serie implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private Long fecha;
    private Integer calificacion;
    @ManyToMany(mappedBy = "series", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<Personaje> personajes;
    @ManyToOne()
    @JoinColumn(name = "genero_id", foreignKey = @ForeignKey(name = "fk_genero_id"))
    private Genero genero;
    public Genero getGenero() {
        return genero;
    }
    public void setGenero(Genero genero) {
        this.genero = genero;
    }
    public Serie() {
    }
    public Serie(Long id, String titulo, Long fecha, Integer calificacion) {
        this.id = id;
        this.titulo = titulo;
        this.fecha = fecha;
        this.calificacion = calificacion;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public Long getFecha() {
        return fecha;
    }
    public void setFecha(Long fecha) {
        this.fecha = fecha;
    }
    public Integer getCalificacion() {
        return calificacion;
    }
    public void setCalificacion(Integer calificacion) {
        this.calificacion = calificacion;
    }
    public List<Personaje> getPersonajes() {
        return personajes;
    }
    public void setPersonajes(List<Personaje> personajes) {
        this.personajes = personajes;
    }
    @Override
    public String toString() {
        return "Serie{" +
                "titulo='" + titulo + '\'' +
                ", fecha=" + fecha +
                ", calificacion=" + calificacion +
                ", personajes=" + personajes +
                '}';
    }
}
