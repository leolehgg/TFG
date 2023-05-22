package com.example.tfg628v1.servicios.Diario;

import com.example.tfg628v1.repositorios.DesarrolloPersonal.desarrolloPersonalRepository;
import com.example.tfg628v1.repositorios.Diario.eventoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

@Data
@Service
public class EventoService {

    //Importaciones
    private final eventoRepository repository ;

}
