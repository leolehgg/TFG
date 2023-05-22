package com.example.tfg628v1.controladores.restapi;

import com.example.tfg628v1.dto.JpaMapper;
import com.example.tfg628v1.dto.dp.LibroDto;
import com.example.tfg628v1.entidades.DesarrolloPersonal.Libro;
import com.example.tfg628v1.servicios.DesarrolloPersonal.libroService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@Data
@RestController
@RequestMapping("/api/desarrolloPersonal")
public class DpRestController {

    private final libroService libroService;
    private final JpaMapper mapper;


    @GetMapping({""})
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<List<LibroDto>> getAll() {
        try {
            List<LibroDto> libros = mapper.toDtoList(libroService.findAll());
            return new ResponseEntity<>(libros, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping({ "/{id}" })
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    public ResponseEntity<LibroDto> getOne(@PathVariable("id") Long id) {
        Optional<LibroDto> libro = Optional.ofNullable(mapper.toDto(
                libroService.findById(id)));
        return libro.map(d -> new ResponseEntity<>(d, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }


    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Map<String, Object>> add(@Valid @RequestBody LibroDto libroDto) {
        try {
            Long id = libroService.save(mapper.toEntity(libroDto)).getId();
            return new ResponseEntity<>(Collections.singletonMap("id", id), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(Collections.singletonMap("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @PutMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Map<String, Object>> update(@Valid @RequestBody LibroDto libroDto,
                                                      @PathVariable("id") Long id) {
        try {
            Libro t = libroService.findById(id);
            if (t != null) {
                libroService.save(mapper.toEntity(libroDto));
                return new ResponseEntity<>(null, HttpStatus.OK);
            } else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(Collections.singletonMap("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping(value = "/{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<Map<String, Object>> delete(@PathVariable("id") Long id) {
        try {
            Libro f = libroService.findById(id);
            if (f != null) {
                libroService.deleteById(id);
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else
                return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return new ResponseEntity<>(Collections.singletonMap("error", e.getMessage()),
                    HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
