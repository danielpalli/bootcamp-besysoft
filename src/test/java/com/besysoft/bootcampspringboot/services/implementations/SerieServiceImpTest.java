package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Serie;
import com.besysoft.bootcampspringboot.repositories.database.SerieRepository;
import com.besysoft.bootcampspringboot.services.interfaces.SerieService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
@SpringBootTest
class SerieServiceImpTest {

    @MockBean
    private SerieRepository serieRepository;
    @Autowired
    private SerieService serieService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("[serieService] - Obtener lista de series")
    void obtenerCatalogo() {
        when(serieRepository.findAll())
                .thenReturn(DatosDummy.getListaSeries());

        List<Serie> iterableSeries = (List<Serie>) serieService.obtenerCatalogo();

        assertThat(iterableSeries.size()).isEqualTo(3);

        verify(serieRepository).findAll();
    }

    @Test
    @DisplayName("[serieService] - Obtener serie por id")
    void obtenerSeriePorId() {
        Serie serie = DatosDummy.getSerieLosJuegosDelHambre();
        BDDMockito.given(serieRepository.findById(serie.getId())).willReturn(Optional.of(serie));

        Optional<Serie> oSerie = serieService.obtenerSeriePorId(serie.getId());

        assertThat(oSerie.isPresent()).isTrue();
        assertThat(oSerie.get().getTitulo()).isEqualTo(serie.getTitulo());
    }

    @Test
    @DisplayName("[serieService] - Nueva serie")
    void nuevaSerie() {
        Serie serie = DatosDummy.getSerieLosJuegosDelHambre();
        serieService.nuevaSerie(serie);
        ArgumentCaptor<Serie> serieArgumentCaptor = ArgumentCaptor.forClass(Serie.class);

        verify(serieRepository).save(serieArgumentCaptor.capture());

        Serie serieCaptor = serieArgumentCaptor.getValue();

        Assertions.assertThat(serieCaptor).isEqualTo(serie);
    }

    @Test
    @DisplayName("[serieService] - Nueva serie con error")
    void nuevaSerieError() {
        Serie serie = DatosDummy.getSerieLosJuegosDelHambre();
        BDDMockito.given(serieRepository.obtenerSeriePorNombre(serie.getTitulo()))
                .willReturn(Optional.of(serie));

        assertThatThrownBy(() -> serieService.nuevaSerie(serie))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("La serie ya existe");
    }

    @Test
    @DisplayName("[serieService] - Obtener Serie por nombre")
    void obtenerSeriePorCalificacion() {
        Integer desde = 1;
        Integer hasta = 1;

        BDDMockito.given(serieRepository.obtenerSeriePorCalificacion(desde, hasta))
                .willReturn(DatosDummy.getListaSeries());

        List<Serie> listaSeries = (List<Serie>) serieService.obtenerSeriePorCalificacion(desde, hasta);

        assertThat(listaSeries.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[serieService] - Obtener por fecha")
    void obtenerSeriePorFecha() {
        BDDMockito.given(serieRepository.obtenerSeriePorFecha(1L, 5L))
                .willReturn(DatosDummy.getListaSeries());

        List<Serie> listaSeries = (List<Serie>) serieService.obtenerSeriePorFecha(1L, 5L);

        assertThat(listaSeries.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[serieService] - Obtener por titulo")
    void obtenerSeriesPorTitulo() {
        BDDMockito.given(serieRepository.obtenerSeriesPorTitulo("Los Juegos del Hambre"))
                .willReturn(DatosDummy.getListaSeries());

        List<Serie> listaSeries = (List<Serie>) serieService.obtenerSeriesPorTitulo("Los Juegos del Hambre");

        assertThat(listaSeries.size()).isEqualTo(3);
    }
}