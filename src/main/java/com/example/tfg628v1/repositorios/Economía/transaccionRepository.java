package com.example.tfg628v1.repositorios.Economía;

import com.example.tfg628v1.entidades.Economia.Transaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface transaccionRepository extends JpaRepository<Transaccion, Long> {
}
