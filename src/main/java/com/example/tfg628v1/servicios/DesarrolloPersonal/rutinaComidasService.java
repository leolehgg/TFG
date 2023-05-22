package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.entidades.DesarrolloPersonal.RutinaComidas;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.desarrolloPersonalRepository;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.rutinaComidasRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class rutinaComidasService {

    //Importaciones
    private final rutinaComidasRepository repositorio ;


    public List<RutinaComidas> findAll() {
        return repositorio.findAll();
    }

    public Optional<RutinaComidas> findById(long id) {
        return repositorio.findById(id);
    }


    public RutinaComidas save(RutinaComidas p) {
        return repositorio.save(p);
    }

    public void saveAll(List<RutinaComidas> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(RutinaComidas e) {
        repositorio.delete(e);
    }
    public void deleteById(Long id) {
        repositorio.deleteById(id);
    }
    @Transactional
    public void deleteAll() {
        repositorio.deleteAllInBatch();
    }
}
