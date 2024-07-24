package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Personaje;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@DataJpaTest
class PersonajeRepositoryTest {
    @Autowired
    private PersonajeRepository personajeRepository;

    @BeforeEach
    void setUp() {
        personajeRepository.save(DatosDummy.getPersonajeThor());
        personajeRepository.save(DatosDummy.getPersonajeIronMan());
        personajeRepository.save(DatosDummy.getPersonajeHulk());
    }

    @AfterEach
    void tearDown() {
        personajeRepository.deleteAll();
    }

    @Test
    void buscarPersonajePorNombre() {
        String testUno = "Thor";

        Optional<Personaje> oPersonaje = personajeRepository.buscarPersonajePorNombre(DatosDummy.getPersonajeThor().getNombre());

        assertTrue(oPersonaje.isPresent());
        assertEquals(testUno, oPersonaje.get().getNombre());
    }

    @Test
    void buscarPersonajePorEdad() {
        Integer desde = 30;
        Integer hasta = 45;

        List<Personaje> personajes = (List<Personaje>) personajeRepository.buscarPersonajePorEdad(desde, hasta);

        assertEquals(2, personajes.size());
    }
}