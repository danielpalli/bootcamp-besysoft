package com.besysoft.bootcampspringboot.dto.mapper.mapstruct;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.dto.PersonajeDTO;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PersonajeMapper {
    PersonajeDTO mapToDto(Personaje entity);
    Personaje mapToEntity(PersonajeDTO dto);
    List<PersonajeDTO> mapListToDto(List<Personaje> personajes);
}
