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
public class Libro {

    @Id
    @GeneratedValue
    private long id;
    private String nombre;
    private String autor;
    private String opinion;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private DesarrolloPersonal desarrolloPersonal;


}
