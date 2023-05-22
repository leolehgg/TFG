package com.example.tfg628v1.entidades.DesarrolloPersonal;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Ejercicio {

    @Id
    @GeneratedValue
    private long id;
    private String nombreEjercicio;
    private int repeticiones;
    private int series;
    private String musculo;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private RutinaEjercicioFisico rutinaEjercicioFisico;
}
