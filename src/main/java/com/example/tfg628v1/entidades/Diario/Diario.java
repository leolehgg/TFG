package com.example.tfg628v1.entidades.Diario;

import com.example.tfg628v1.entidades.Economia.Transaccion;
import com.example.tfg628v1.entidades.Usuario.Usuario;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Diario {
    @Id
    @GeneratedValue
    private long id;
    private String titulo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fechaNac;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(unique = true)
    private Usuario usuario;

    @OneToMany(mappedBy = "diario", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Evento> eventos = new ArrayList<>();
    public void adddiario (Evento e) {
        eventos.add(e);
        e.setDiario(this);
    }
    public void removediario(Evento e) {
        eventos.remove(e);
        e.setDiario(null);
    }

    @OneToMany(mappedBy = "diario", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<SeguimientoDeHabitos> seguimientoDeHabitosList = new ArrayList<>();
    public void addseguimientodehabitos (SeguimientoDeHabitos e) {
        seguimientoDeHabitosList.add(e);
        e.setDiario(this);
    }
    public void removeseguimientodehabitos(SeguimientoDeHabitos e) {
        seguimientoDeHabitosList.remove(e);
        e.setDiario(null);
    }

    @OneToMany(mappedBy = "diario", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Tarea> tareas = new ArrayList<>();
    public void addtarea (Tarea e) {
        tareas.add(e);
        e.setDiario(this);
    }
    public void removetarea (Tarea e) {
        tareas.remove(e);
        e.setDiario(null);
    }

}
