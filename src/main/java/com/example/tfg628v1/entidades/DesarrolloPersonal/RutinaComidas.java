package com.example.tfg628v1.entidades.DesarrolloPersonal;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class RutinaComidas {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;
    private String descripcion;
    private int calorias;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private TipoComida tipoComida;
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private DesarrolloPersonal desarrolloPersonal;


    @OneToMany(mappedBy = "rutinacomida", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    private List<Comida> comidas = new ArrayList<>();

    public void addComida (Comida e) {
        comidas.add(e);
        e.setRutinacomida(this);
    }

    public void removeComida (Comida e) {
        comidas.remove(e);
        e.setRutinacomida(null);
    }

}
