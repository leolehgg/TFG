package com.example.tfg628v1.repositorios.Usuario;


import com.example.tfg628v1.entidades.Usuario.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface usuarioRepository extends JpaRepository<Usuario, Long> {
  Usuario findFirstByUsername(String username);
}
