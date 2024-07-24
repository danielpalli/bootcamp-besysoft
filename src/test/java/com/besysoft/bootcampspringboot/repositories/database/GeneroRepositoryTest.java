package com.besysoft.bootcampspringboot.repositories.database;

import com.besysoft.bootcampspringboot.datos.DatosDummy;
import com.besysoft.bootcampspringboot.dominio.Genero;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class GeneroRepositoryTest {

    @Autowired
    private GeneroRepository generoRepository;

    @BeforeEach
    void setUp() {
        generoRepository.save(DatosDummy.getGeneroComedia());
        generoRepository.save(DatosDummy.getGeneroDrama());
        generoRepository.save(DatosDummy.getGeneroTerror());
    }

    @AfterEach
    void tearDown() {
        generoRepository.deleteAll();
    }

    @Test
    void buscarGeneroPorNombre() {
        String testUno = "Comedia";

        Optional<Genero> oGenero = generoRepository.buscarGeneroPorNombre(DatosDummy.getGeneroComedia().getGenero());

        assertThat(oGenero.isPresent()).isTrue();
        assertThat(oGenero.get().getGenero()).isEqualTo(testUno);
    }
}