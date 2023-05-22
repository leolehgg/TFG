package com.example.tfg628v1.servicios.DesarrolloPersonal;

import com.example.tfg628v1.entidades.DesarrolloPersonal.TipoComida;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.tipoComidaRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class tipoComidaService {
    //Importaciones
    private final tipoComidaRepository repositorio ;


    public List<TipoComida> findAll() {
        return repositorio.findAll();
    }

    public Optional<TipoComida> findById(long id) {
        return repositorio.findById(id);
    }


    public TipoComida save(TipoComida p) {
        return repositorio.save(p);
    }

    public void saveAll(List<TipoComida> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(TipoComida e) {
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
