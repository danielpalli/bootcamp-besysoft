package com.besysoft.bootcampspringboot.dto.mapper.mapstruct;

import com.besysoft.bootcampspringboot.dominio.Serie;
import com.besysoft.bootcampspringboot.dto.SerieDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface SerieMapper {
    SerieDTO mapToDto(Serie entity);
    Serie mapToEntity(SerieDTO dto);
    List<SerieDTO> mapListToDto(List<Serie> series);
}
