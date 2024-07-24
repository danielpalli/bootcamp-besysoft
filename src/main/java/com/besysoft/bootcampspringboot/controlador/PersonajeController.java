package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.dto.PersonajeDTO;
import com.besysoft.bootcampspringboot.dto.mapper.mapstruct.PersonajeMapper;
import com.besysoft.bootcampspringboot.services.interfaces.PersonajeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.*;

@RestController
@RequestMapping("/personajes")
@AllArgsConstructor
@Slf4j
@Api(value = "Personaje Controller", tags = "Acciones permitidas para la entidad Personaje")
public class PersonajeController {
    private final PersonajeService personajeService;
    private final PersonajeMapper mapper;

    @GetMapping
    @ApiOperation(value = "Obtener todos los personajes")
    public ResponseEntity<?> obtenerPersonajes() {
        List<Personaje> personajes = (List<Personaje>) this.personajeService.obtenerPersonajes();
        List<PersonajeDTO> personajesDTO = mapper.mapListToDto(personajes);
        return ResponseEntity.status(HttpStatus.OK).body(personajesDTO);
    }
    @PostMapping
    @ApiOperation(value = "Crear un nuevo personaje")
    public ResponseEntity<?> nuevoPersonaje(@Valid @RequestBody PersonajeDTO personaje) {
        Personaje entity = mapper.mapToEntity(personaje);
        entity = this.personajeService.altaPersonaje(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un personaje por id")
    public ResponseEntity<?> obtenerPersonajePorId(@PathVariable Long id) {
        Optional<Personaje> personaje = this.personajeService.obtenerPersonajePorId(id);
        PersonajeDTO personajeDTO = mapper.mapToDto(personaje.get());

        return ResponseEntity.status(HttpStatus.OK).body(personajeDTO);
    }
    @GetMapping("/edad")
    @ApiOperation(value = "Obtener personajes por edad")
    public ResponseEntity<?> obtenerPersonajesPorEdad(@RequestParam Integer desde, @RequestParam Integer hasta) {
        List<Personaje> personajes = (List<Personaje>) this.personajeService.obtenerPersonajesPorEdad(desde, hasta);
        List<PersonajeDTO> personajesDTO = mapper.mapListToDto(personajes);

        return ResponseEntity.status(HttpStatus.OK).body(personajesDTO);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar un personaje")
    public ResponseEntity<?> actualizarPersonaje(@PathVariable Long id,@Valid @RequestBody PersonajeDTO personaje) {
        Personaje entity = mapper.mapToEntity(personaje);
        return ResponseEntity.status(HttpStatus.OK).body(this.personajeService.actualizarPersonaje(id ,entity));
    }
    @GetMapping("/nombre")
    @ApiOperation(value = "Obtener personaje por nombre")
    public ResponseEntity<?> obtenerPersonajePorNombre(@RequestParam String nombre) {
        Optional<Personaje> personaje = this.personajeService.obtenerPersonajePorNombre(nombre);
        PersonajeDTO personajeDTO = mapper.mapToDto(personaje.get());
        return ResponseEntity.status(HttpStatus.OK).body(personajeDTO);
    }
}

