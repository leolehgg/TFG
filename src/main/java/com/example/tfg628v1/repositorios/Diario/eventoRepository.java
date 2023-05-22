package com.example.tfg628v1.repositorios.Diario;

import com.example.tfg628v1.entidades.Diario.Evento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface eventoRepository extends JpaRepository<Evento, Long> {
}
