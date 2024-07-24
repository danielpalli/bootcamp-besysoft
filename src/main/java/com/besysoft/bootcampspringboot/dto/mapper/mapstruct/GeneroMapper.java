package com.besysoft.bootcampspringboot.dto.mapper.mapstruct;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dto.GeneroDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface GeneroMapper {
    GeneroDTO mapToDto(Genero entity);
    Genero mapToEntity(GeneroDTO dto);
    List<GeneroDTO> mapListToDto(List<Genero> generos);
}
