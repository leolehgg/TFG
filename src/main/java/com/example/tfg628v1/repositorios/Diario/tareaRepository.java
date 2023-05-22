package com.example.tfg628v1.repositorios.Diario;

import com.example.tfg628v1.entidades.Diario.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tareaRepository extends JpaRepository<Tarea, Long> {
}
