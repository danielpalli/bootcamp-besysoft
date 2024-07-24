package com.besysoft.bootcampspringboot.dto.mapper;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dto.GeneroDTO;

import java.util.List;
import java.util.stream.Collectors;
public class GeneroMapper {
    public static Genero mapToEntity(GeneroDTO dto) {
        Genero genero = new Genero();
        genero.setId(genero.getId());
        genero.setGenero(dto.getGenero());
        return genero;
    }
    public static GeneroDTO mapToDto(Genero entity) {
        GeneroDTO generoDTO = new GeneroDTO();
        generoDTO.setId(entity.getId());
        generoDTO.setGenero(entity.getGenero());
        return generoDTO;
    }

    public static List<GeneroDTO> mapListToDto(List<Genero> generos) {
        return generos.stream()
                .map(GeneroMapper::mapToDto)
                .collect(Collectors.toList());
    }

}
