package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.libroRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class libroService {

    //Importaciones
    private final libroRepository repositorio ;

    public List<Libro> findAll() {
        return repositorio.findAll();
    }

    public Libro findById(long id) {
        return repositorio.findById(id).orElse(null);
    }

    public Optional<Libro> findByNombre(String nombre) {
        return repositorio.findByNombre(nombre);
    }

    public Libro save(Libro p) {
        return repositorio.save(p);
    }

    public void saveAll(List<Libro> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(Libro e) {
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
