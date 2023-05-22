package com.example.tfg628v1.servicios.Economia;

import com.example.tfg628v1.entidades.DesarrolloPersonal.Ejercicio;
import com.example.tfg628v1.entidades.Economia.Transaccion;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.desarrolloPersonalRepository;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.ejercicioRepository;
import com.example.tfg628v1.repositorios.Economía.transaccionRepository;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class transaccionService {

    //Importaciones
    private final transaccionRepository repositorio ;

    public List<Transaccion> findAll() {
        return repositorio.findAll();
    }

    public Optional<Transaccion> findById(long id) {
        return repositorio.findById(id);
    }


    public Transaccion save(Transaccion p) {
        return repositorio.save(p);
    }

    public void saveAll(List<Transaccion> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(Transaccion e) {
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
