package com.example.tfg628v1.entidades.DesarrolloPersonal;

import com.example.tfg628v1.entidades.Usuario.Usuario;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class DesarrolloPersonal {

    @Id
    @GeneratedValue
    private long id;
    private String observaciones;
    private String descripción;

    @ToString.Exclude
    @OneToOne
    @JoinColumn(unique = true)
    private Usuario usuario;


    @OneToMany(mappedBy = "desarrolloPersonal", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Libro> libros = new ArrayList<>();
    public void addlibro (Libro e) {
        libros.add(e);
        e.setDesarrolloPersonal(this);
    }
    public void removelibro (Libro e) {
        libros.remove(e);
        e.setDesarrolloPersonal(null);
    }

    @OneToMany(mappedBy = "desarrolloPersonal", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<ObjetivoPersonal> objetivosPersonales = new ArrayList<>();
    public void addobjetivo (ObjetivoPersonal e) {
        objetivosPersonales.add(e);
        e.setDesarrolloPersonal(this);
    }
    public void removeobjetivo (ObjetivoPersonal e) {
        objetivosPersonales.remove(e);
        e.setDesarrolloPersonal(null);
    }

    @OneToMany(mappedBy = "desarrolloPersonal", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<RutinaComidas> rutinascomidas = new ArrayList<>();
    public void addrutinaComida (RutinaComidas e) {
        rutinascomidas.add(e);
        e.setDesarrolloPersonal(this);
    }
    public void removerutinaComida(RutinaComidas e) {
        rutinascomidas.remove(e);
        e.setDesarrolloPersonal(null);
    }

    @OneToMany(mappedBy = "desarrolloPersonal", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<RutinaEjercicioFisico> rutinasejerciciofisico = new ArrayList<>();
    public void addrutinaEjercicio (RutinaEjercicioFisico e) {
        rutinasejerciciofisico.add(e);
        e.setDesarrolloPersonal(this);
    }
    public void removerutinaEjercicio (RutinaEjercicioFisico e) {
        rutinasejerciciofisico.remove(e);
        e.setDesarrolloPersonal(null);
    }

}
