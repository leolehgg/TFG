package com.example.tfg628v1.entidades.DesarrolloPersonal;


import lombok.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Comida {

    @Id
    @GeneratedValue
    private Long id;
    private String nombre;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private RutinaComidas rutinacomida;




}
