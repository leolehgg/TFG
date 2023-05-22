package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Comida;
import com.example.tfg628v1.entidades.DesarrolloPersonal.Ejercicio;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.comidaRepository;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.ejercicioRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class comidaService {

    //Importaciones
    private final comidaRepository repositorio;


    public List<Comida> findAll() {
        return repositorio.findAll();
    }

    public Optional<Comida> findById(long id) {
        return repositorio.findById(id);
    }


    public Comida save(Comida p) {
        return repositorio.save(p);
    }

    public void saveAll(List<Comida> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(Comida e) {
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
