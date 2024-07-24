package com.besysoft.bootcampspringboot.controlador;

import com.besysoft.bootcampspringboot.dominio.Serie;
import com.besysoft.bootcampspringboot.dto.SerieDTO;
import com.besysoft.bootcampspringboot.dto.mapper.mapstruct.SerieMapper;
import com.besysoft.bootcampspringboot.services.interfaces.SerieService;
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
@RequestMapping("/series")
@AllArgsConstructor
@Slf4j
@Api(value = "Serie Controller", tags = "Acciones permitidas para la entidad Serie")
public class SerieController {
    private final SerieService serieService;
    private final SerieMapper mapper;

    @GetMapping()
    @ApiOperation(value = "Obtener todos las series")
    public ResponseEntity<?> obtenerCatalogo() {
        List<Serie> series = (List<Serie>) this.serieService.obtenerCatalogo();
        List<SerieDTO> seriesDTO = mapper.mapListToDto(series);
        return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);
    }
    @GetMapping("/{id}")
    @ApiOperation(value = "Obtener una serie por id")
    public ResponseEntity<?> obtenerSeriePorId(@PathVariable Long id) {
        Optional<Serie> serie = this.serieService.obtenerSeriePorId(id);
        SerieDTO serieDTO = mapper.mapToDto(serie.get());
        return ResponseEntity.status(HttpStatus.OK).body(serieDTO);
    }
    @PostMapping
    @ApiOperation(value = "Crear una nueva serie")
    public ResponseEntity<?> crearSerie(@Valid @RequestBody SerieDTO serie) {
        Serie entity = mapper.mapToEntity(serie);
        entity = this.serieService.nuevaSerie(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(entity);
    }
    @PutMapping("/{id}")
    @ApiOperation(value = "Actualizar una serie")
    public ResponseEntity<?> actualizarSerie(@PathVariable Long id, @Valid @RequestBody SerieDTO serie) {

        Serie entity = mapper.mapToEntity(serie);
        return ResponseEntity.status(HttpStatus.OK).body(this.serieService.actualizarSerie(id, entity));
    }
    @GetMapping("/calificacion")
    @ApiOperation(value = "Obtener una serie por calificacion")
    public ResponseEntity<?> obtenerCatalogoPorCalificacion(@RequestParam Integer desde, @RequestParam Integer hasta) {
        List<Serie> series = (List<Serie>) this.serieService.obtenerSeriePorCalificacion(desde, hasta);
        List<SerieDTO> seriesDTO = mapper.mapListToDto(series);
        return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);
    }
    @GetMapping("/fecha")
    @ApiOperation(value = "Obtener una serie por fecha")
    public ResponseEntity<?> obtenerSeriePorFecha(@RequestParam Long desde, @RequestParam Long hasta) {
        List<Serie> series = (List<Serie>) this.serieService.obtenerSeriePorFecha(desde, hasta);
        List<SerieDTO> seriesDTO = mapper.mapListToDto(series);
        return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);
    }
    @GetMapping("/titulo")
    @ApiOperation(value = "Obtener una serie por titulo")
    public ResponseEntity<?> obtenerCatalogoPorTitulo(@RequestParam String titulo) {
        List<Serie> series = (List<Serie>) this.serieService.obtenerSeriesPorTitulo(titulo);
        List<SerieDTO> seriesDTO = mapper.mapListToDto(series);
        return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);
    }
    @GetMapping("/genero")
    @ApiOperation(value = "Obtener una serie por genero")
    public ResponseEntity<?> obtenerCatalogoPorGenero(@RequestParam String genero) {
        List<Serie> series = (List<Serie>) this.serieService.obtenerSeriePorGenero(genero);
        List<SerieDTO> seriesDTO = mapper.mapListToDto(series);
        return ResponseEntity.status(HttpStatus.OK).body(seriesDTO);
    }
}
