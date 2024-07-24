package com.besysoft.bootcampspringboot.services.implementations;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import com.besysoft.bootcampspringboot.repositories.database.PersonajeRepository;
import com.besysoft.bootcampspringboot.services.interfaces.PersonajeService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.BDDMockito;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class PersonajeServiceImpTest {
    @MockBean
    private PersonajeRepository personajeRepository;
    @Autowired
    private PersonajeService personajeService;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }

    @Test
    @DisplayName("[personajeService] - Obtener lista de personajes")
    void obtenerPersonajes() {
        when(personajeRepository.findAll())
                .thenReturn(DatosDummy.getListaPersonajes());

        List<Personaje> iterablePersonajes = (List<Personaje>) personajeService.obtenerPersonajes();

        assertThat(iterablePersonajes.size()).isEqualTo(3);
        verify(personajeRepository).findAll();
    }

    @Test
    @DisplayName("[personajeService] - Alta de personaje")
    void altaPersonaje() {
        Personaje personaje = DatosDummy.getPersonajeThor();
        personajeService.altaPersonaje(personaje);
        ArgumentCaptor<Personaje> argumentCaptor = ArgumentCaptor.forClass(Personaje.class);
        verify(personajeRepository).save(argumentCaptor.capture());
        Personaje personajeCapturado = argumentCaptor.getValue();
        assertThat(personajeCapturado).isEqualTo(personaje);
    }

    @Test
    @DisplayName("[personajeService] - Alta personaje con error")
    void altaPersonajeError() {
        Personaje personaje = DatosDummy.getPersonajeThor();
        BDDMockito.given(personajeRepository.buscarPersonajePorNombre(personaje.getNombre()))
                .willReturn(Optional.of(personaje));

        assertThatThrownBy(() -> personajeService.altaPersonaje(personaje))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("El personaje ya existe");
    }

    @Test
    @DisplayName("[personajeService] - Obtener personaje por id")
    void obtenerPersonajePorId() {
        Personaje personaje = DatosDummy.getPersonajeThor();

        BDDMockito.given(personajeRepository.findById(personaje.getId()))
                .willReturn(Optional.of(personaje));

        Optional<Personaje> oPersonaje = personajeService.obtenerPersonajePorId(personaje.getId());

        Assertions.assertThat(oPersonaje.isPresent()).isTrue();
        Assertions.assertThat(oPersonaje.get().getNombre()).isEqualTo(personaje.getNombre());
    }

    @Test
    @DisplayName("[personajeService] - Obtener personaje por id con error")
    void obtenerPersonajePorIdError() {
        Personaje personaje = DatosDummy.getPersonajeThor();
        BDDMockito.given(personajeRepository.findById(personaje.getId()))
                .willReturn(Optional.empty());

        Optional<Personaje> oPersonaje = personajeService.obtenerPersonajePorId(personaje.getId());

        Assertions.assertThat(oPersonaje.isPresent()).isFalse();
    }

    @Test
    @DisplayName("[personajeService] - Obtener personajes por edad")
    void obtenerPersonajesPorEdad() {
        when(personajeRepository.buscarPersonajePorEdad(20, 55))
                .thenReturn(DatosDummy.getListaPersonajes());

        List<Personaje> iterablePersonajes = (List<Personaje>) personajeService.obtenerPersonajesPorEdad(20, 55);

        assertThat(iterablePersonajes.size()).isEqualTo(3);
    }

    @Test
    @DisplayName("[personajeService] - Obtener personajes por nombre")
    void obtenerPersonajePorNombre() {
        String nombre = "Thor";
        when(personajeRepository.buscarPersonajePorNombre(nombre))
                .thenReturn(Optional.of(DatosDummy.getPersonajeThor()));

        Optional<Personaje> oPersonaje = personajeService.obtenerPersonajePorNombre(nombre);

        Assertions.assertThat(oPersonaje.isPresent()).isTrue();
        Assertions.assertThat(oPersonaje.get().getNombre()).isEqualTo(nombre);
    }
}