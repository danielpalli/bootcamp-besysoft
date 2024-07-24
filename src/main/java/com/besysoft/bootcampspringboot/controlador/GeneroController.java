package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.dto.GeneroDTO;
import com.besysoft.bootcampspringboot.dto.mapper.mapstruct.GeneroMapper;
import com.besysoft.bootcampspringboot.services.interfaces.GeneroService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/generos")
@AllArgsConstructor
@Slf4j
@Api(value = "Genero Controller", tags = "Acciones permitidas para la entidad Genero")
public class GeneroController {
    private final GeneroService generoService;
    private final GeneroMapper mapper;

    @GetMapping
    @ApiOperation(value = "Obtener todos los generos")
    public ResponseEntity<?> obtenerGeneros() {
        List<Genero> generos = (List<Genero>) this.generoService.obtenerGeneros();
        List<GeneroDTO> generosDTO = mapper.mapListToDto(generos);
        return ResponseEntity.status(HttpStatus.OK).body(generosDTO);
    }

    @PostMapping
    @ApiOperation(value = "Crear un nuevo genero")
    public ResponseEntity<?> crearGenero(@Valid @RequestBody GeneroDTO genero) {
        Genero entity = mapper.mapToEntity(genero);
        entity = this.generoService.nuevoGenero(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener un genero por id")
    public ResponseEntity<?> obtenerGeneroPorId(@PathVariable Long id) {
        Optional<Genero> oGenero = this.generoService.obtenerGeneroPorId(id);
        GeneroDTO generoDTO = mapper.mapToDto((Genero) oGenero.get());
        log.info("Genero: " + generoDTO);
        return ResponseEntity.status(HttpStatus.OK).body(generoDTO);
    }

    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar un genero por id")
    public ResponseEntity<?> actualizarGenero(@PathVariable Long id, @Valid @RequestBody GeneroDTO genero) {
        Genero entity = mapper.mapToEntity(genero);
        return ResponseEntity.status(HttpStatus.OK).body(this.generoService.actualizarGenero(id, entity));
    }
}

