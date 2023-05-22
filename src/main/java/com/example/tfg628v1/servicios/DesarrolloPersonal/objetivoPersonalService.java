package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.entidades.DesarrolloPersonal.ObjetivoPersonal;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.desarrolloPersonalRepository;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.libroRepository;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.objetivoPersonalRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class objetivoPersonalService {

    //Importaciones
    private final objetivoPersonalRepository repositorio ;

    public List<ObjetivoPersonal> findAll() {
        return repositorio.findAll();
    }

    public Optional<ObjetivoPersonal> findById(long id) {
        return repositorio.findById(id);
    }

    public ObjetivoPersonal save(ObjetivoPersonal p) {
        return repositorio.save(p);
    }

    public void saveAll(List<ObjetivoPersonal> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(ObjetivoPersonal e) {
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
