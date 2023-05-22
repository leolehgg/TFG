package com.example.tfg628v1.entidades.DesarrolloPersonal;

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
public class RutinaEjercicioFisico {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private DesarrolloPersonal desarrolloPersonal;

    @OneToMany(mappedBy = "rutinaEjercicioFisico", cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    private List<Ejercicio> rutinasfisico = new ArrayList<>();
    public void addrutinafisica(Ejercicio e) {
        rutinasfisico.add(e);
        e.setRutinaEjercicioFisico(this);
    }
    public void removerutinafisica(Ejercicio e) {
        rutinasfisico.remove(e);
        e.setRutinaEjercicioFisico(null);
    }



}
