package com.example.tfg628v1.entidades.Diario;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class SeguimientoDeHabitos {

    @Id
    @GeneratedValue
    private long id;
    private Boolean cuerpo;
    private Boolean mente;
    private Boolean espiritu;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private Diario diario;

}
