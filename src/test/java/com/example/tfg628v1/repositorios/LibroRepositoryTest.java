package com.example.tfg628v1.repositorios;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.libroRepository;
import com.github.database.rider.spring.api.DBRider;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest(showSql = false)
@DBRider
public class LibroRepositoryTest {

    //Importaciones
    @Autowired
    private TestEntityManager entityManager;
    @Autowired
    private libroRepository libroRepository;

    @Test
    void x(){
        Libro libro = Libro.builder()
                .nombre("El ingenioso hidalgo Don Quijote de la Mancha")
                .autor("Miguel de Cervantes Saavedra")
                .build();
        log.info("=========================================================="+ libro);
        libroRepository.save(libro);
        List<Libro> resultados = libroRepository.findByNombreContainsIgnoreCase("Quijote");
        int numLibros = 1;
        assertThat(resultados).hasSize(numLibros);

    }

    @Test
    void x2 (){
        Libro libro1 = Libro.builder()
                .nombre("El ingenioso hidalgo Don Quijote de la Mancha")
                .autor("Miguel de Cervantes Saavedra")
                .build();
        Libro libro2 = Libro.builder()
                .nombre("La Galatea")
                .autor("Miguel de Cervantes Saavedra")
                .build();

        libroRepository.save(libro1);
        libroRepository.save(libro2);

        libroRepository.deleteAllInBatch();

        assertThat(libroRepository.findAll()).isEmpty();


    }

    @Test
    void x3 (){
        Libro libro1 = Libro.builder()
                .id(1L)
                .nombre("El ingenioso hidalgo Don Quijote de la Mancha")
                .autor("Miguel de Cervantes Saavedra")
                .build();
        Libro libro2 = Libro.builder()
                .id(2L)
                .nombre("La Galatea")
                .autor("Miguel de Cervantes Saavedra")
                .build();

        libroRepository.save(libro1);
        libroRepository.save(libro2);
        String nombreLibro = libroRepository.findById(1L).orElse(null).getNombre();
        String nombre = "El ingenioso hidalgo Don Quijote de la Mancha";
        log.info("==================================="+ nombreLibro);
        assertThat(nombreLibro).isEqualTo(nombre);

    }

}
