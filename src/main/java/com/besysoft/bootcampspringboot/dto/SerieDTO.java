package com.besysoft.bootcampspringboot.dto;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import lombok.*;
import org.mapstruct.Mapping;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {

    private Long id;
    @NotBlank(message = "El título no puede estar vacío")
    private String titulo;
    @Positive(message = "La fecha debe ser un número positivo")
    private Long fecha;
    @Positive(message = "La calificación debe ser un número positivo")
    private Integer calificacion;
    private List<Personaje> personajes;
}
