package com.example.tfg628v1.repositorios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface libroRepository extends JpaRepository<Libro, Long> {

    Optional<Libro> findByNombre(String nombre);
    List<Libro> findByNombreContainsIgnoreCase(String filtro);


}
