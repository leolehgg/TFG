package com.example.tfg628v1.entidades.Diario;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@ToString
@Entity
public class Tarea {

    @Id
    @GeneratedValue
    private long id;
    private String titulo;
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private LocalDate fecha;
    private String contenido;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY )
    private Diario diario;

}
