package com.example.tfg628v1.servicios.Economia;

import com.example.tfg628v1.repositorios.DesarrolloPersonal.desarrolloPersonalRepository;
import com.example.tfg628v1.repositorios.Economía.economiaRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class economiaService {

    //Importaciones
    private final economiaRepository repository ;

}
