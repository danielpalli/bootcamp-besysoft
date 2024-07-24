package com.besysoft.bootcampspringboot.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GeneroDTO {
    private Long id;
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El nombre del género debe contener solo letras")
    @NotBlank(message = "El nombre del género no puede estar vacío")
    private String genero;
}
