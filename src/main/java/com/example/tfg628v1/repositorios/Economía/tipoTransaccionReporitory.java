package com.example.tfg628v1.repositorios.Economía;

import com.example.tfg628v1.entidades.DesarrolloPersonal.TipoComida;
import com.example.tfg628v1.entidades.Economia.TipoTransaccion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface tipoTransaccionReporitory  extends JpaRepository<TipoTransaccion, Long> {
}
