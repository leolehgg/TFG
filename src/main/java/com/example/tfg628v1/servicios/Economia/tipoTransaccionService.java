package com.example.tfg628v1.servicios.Economia;

import com.example.tfg628v1.entidades.DesarrolloPersonal.TipoComida;
import com.example.tfg628v1.entidades.Economia.TipoTransaccion;
import com.example.tfg628v1.repositorios.DesarrolloPersonal.tipoComidaRepository;
import com.example.tfg628v1.repositorios.Economía.tipoTransaccionReporitory;
import lombok.Data;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Data
@Service
public class tipoTransaccionService {

    //Importaciones
    private final tipoTransaccionReporitory repositorio;


    public List<TipoTransaccion> findAll() {
        return repositorio.findAll();
    }

    public Optional<TipoTransaccion> findById(long id) {
        return repositorio.findById(id);
    }


    public TipoTransaccion save(TipoTransaccion p) {
        return repositorio.save(p);
    }

    public void saveAll(List<TipoTransaccion> lista) {
        repositorio.saveAll(lista);
    }

    public void delete(TipoTransaccion e) {
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
