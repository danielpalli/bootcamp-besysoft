package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Genero;
import com.besysoft.bootcampspringboot.repositories.database.GeneroRepository;
import com.besysoft.bootcampspringboot.services.interfaces.GeneroService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
class GeneroServiceImpTest {

    @MockBean
    private GeneroRepository generoRepository;
    @Autowired
    private GeneroService generoService;

    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("[generoService] - Obtener lista de generos")
    void obtenerGeneros() {
        when(generoRepository.findAll())
                .thenReturn(DatosDummy.getListaGeneros());

        List<Genero> iterableGeneros = (List<Genero>) generoService.obtenerGeneros();

        assertThat(iterableGeneros.size()).isEqualTo(3);

        verify(generoRepository).findAll();
    }

    @Test
    @DisplayName("[generoService] - Alta de genero")
    void nuevoGenero() {
        Genero genero = DatosDummy.getGeneroComedia();

        generoService.nuevoGenero(genero);

        ArgumentCaptor<Genero> generoArgumentCaptor = ArgumentCaptor.forClass(Genero.class);

        verify(generoRepository).save(generoArgumentCaptor.capture());

        Genero generoCaptor = generoArgumentCaptor.getValue();

        assertThat(generoCaptor).isEqualTo(genero);

    }
    @Test
    @DisplayName("[generoService] - Alta de genero con error")
    void nuevoGeneroWithError() {
        Genero genero = DatosDummy.getGeneroComedia();

        BDDMockito.given(generoRepository.buscarGeneroPorNombre(genero.getGenero()))
                .willReturn(Optional.of(genero));

        assertThatThrownBy(() -> generoService.nuevoGenero(genero)).isInstanceOf(RuntimeException.class)
                .hasMessageContaining("El genero ya existe");
    }
    @Test
    @DisplayName("[generoService] - Obtener Genero por Id")
    void obtenerGeneroPorId() {
        Genero genero = DatosDummy.getGeneroComedia();

        BDDMockito.given(generoRepository.findById(genero.getId()))
                .willReturn(Optional.of(genero));

        Optional<Genero> oGenero = generoService.obtenerGeneroPorId(genero.getId());

        assertThat(oGenero.isPresent()).isTrue();
        assertThat(oGenero.get().getGenero()).isEqualTo(genero.getGenero());
    }

    @Test
    @DisplayName("[generoService] - Obtener Genero por Id con error")
    void obtenerGeneroPorIdWithError() {
        Genero genero = DatosDummy.getGeneroComedia();

        BDDMockito.given(generoRepository.findById(genero.getId()))
                .willReturn(Optional.empty());

        Optional<Genero> oGenero = generoService.obtenerGeneroPorId(genero.getId());

        assertThat(oGenero.isPresent()).isFalse();
    }
}