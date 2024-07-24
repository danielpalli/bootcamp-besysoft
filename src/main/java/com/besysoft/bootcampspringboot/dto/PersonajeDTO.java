package com.besysoft.bootcampspringboot.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PersonajeDTO {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El nombre del personaje debe contener solo letras")
    @NotBlank(message = "El nombre del personaje no puede estar vacío")
    private String nombre;
    @Positive(message = "La edad debe ser un número positivo")
    private Integer edad;
    @Positive(message = "El peso debe ser un número positivo")
    private Double peso;
    private String historia;
}
