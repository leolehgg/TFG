package com.example.tfg628v1.repositorios;

import com.example.tfg628v1.repositorios.Usuario.usuarioRepository;
import com.github.database.rider.spring.api.DBRider;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@Slf4j
@DataJpaTest(showSql = false)
@DBRider
public class UsuarioRepositoryTest {

    //Importaciones
    @Autowired
    private usuarioRepository usuarioRepository;


}
