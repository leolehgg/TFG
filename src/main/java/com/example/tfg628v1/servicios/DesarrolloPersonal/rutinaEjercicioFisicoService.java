package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.RutinaEjercicioFisico;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.rutinaEjercicioFisicoRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class rutinaEjercicioFisicoService {

    //Importaciones
    private final rutinaEjercicioFisicoRepository repositorio ;


    public List<RutinaEjercicioFisico> findAll() {
        return repositorio.findAll();
    }

    public Optional<RutinaEjercicioFisico> findById(long id) {
        return repositorio.findById(id);
    }


    public RutinaEjercicioFisico save(RutinaEjercicioFisico p) {
        return repositorio.save(p);
    }

    public void saveAll(List<RutinaEjercicioFisico> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(RutinaEjercicioFisico e) {
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
